new Vue({
    el: "#app",
    data: {},
    create: {},
    methods: {
//    逆编码回调函数
        geocoder_CallBack: function (data) {
            var address = data.regeocode.formattedAddress; //返回地址描述
            $("#tip").html($("#tip").html() + "&nbsp;&nbsp;&nbsp;" + address);
        },
//解析定位错误信息
        onError: function (data) {
            $('#tip').html('定位失败');
        },
        //解析定位结果
        onComplete: function (data) {
            var str = ['定位成功'];
            str.push('经度：' + data.position.getLng());
            str.push('纬度：' + data.position.getLat());
            var self = this;
            var locationEntity = {"lng": data.position.getLng(), "lat": data.position.getLat()};
            //写位置数据
            $.ajax({
                url: '../addLocation',
                data: JSON.stringify(locationEntity),
                type: 'post',
                contentType: "application/json",
                dataType: 'json'
            }).always(function (data) {
                var date = new Date();
                var year = date.getFullYear();
                var month = date.getMonth();
                var day = date.getDate();
                var hours = date.getHours();
                var minutes = date.getMinutes();
                var seconds = date.getSeconds();
                self.$message('位置已更新，更新时间 '+ year +"-"+ month +"-"+ day +" "+ hours +":"+ minutes +":"+ seconds);
                // self.$message('服务器出错');
            });
            if (data.accuracy) {
                str.push('精度：' + data.accuracy + ' 米');
            }//如为IP精确定位结果则没有精度信息
            str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
            $('#tip').html(str.join('&nbsp;&nbsp;&nbsp;'));
            //地址逆编码
            var lnglatXY = [data.position.getLng(), data.position.getLat()]; //已知点坐标
            var geocoder = new AMap.Geocoder({
                radius: 1000,
                extensions: "all"
            });
            geocoder.getAddress(lnglatXY, function (status, result) {
                if (status === 'complete' && result.info === 'OK') {
                    self.geocoder_CallBack(result);
                }
            });
        }
    }, mounted: function () {//loaded vue
        var map = new AMap.Map('container', {resizeEnable: true});
        var self = this;
        //加载地图，调用浏览器定位服务
        map.plugin('AMap.Geolocation', function () {
            geolocation = new AMap.Geolocation({
                enableHighAccuracy: true,//是否使用高精度定位，默认:true
                timeout: 10000,          //超过10秒后停止定位，默认：无穷大
                buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
                buttonPosition: 'RB'
            });
            map.addControl(geolocation);
            setInterval(function () {
                geolocation.getCurrentPosition();
                AMap.event.addListener(geolocation, 'complete', self.onComplete);//返回定位信息
                AMap.event.addListener(geolocation, 'error', self.onError);      //返回定位出错信息
            }, 5000);
        });
    }


});