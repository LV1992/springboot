new Vue({
    el: "#app",
    data: {
        base : $('#base').attr('href')+"/"
    },
    create: {},
    methods: {
        regeocoder: function (lnglatXY) {  //逆地理编码
            var geocoder = new AMap.Geocoder({
                radius: 1000,
                extensions: "all"
            });
            geocoder.getAddress(lnglatXY, function (status, result) {
                if (status === 'complete' && result.info === 'OK') {
                    this.geocoder_CallBack(result);
                }
            });
            var map = new AMap.Map('container', {resizeEnable: true, zoom: 18});

            var marker = new AMap.Marker({  //加点
                map: map,
                position: lnglatXY
            });
            map.setFitView();
        },
        geocoder_CallBack: function (data) {
            var address = data.regeocode.formattedAddress; //返回地址描述
            $("#tip").html(address);
        },
        init: function () {
            //解析定位结果
                var self = this;
                debugger
            setInterval(function () {
                $.ajax({
                    url: self.base + 'getLocation',
                    type: 'get',
                    dataType: 'json'
                }).done(function (rs) {
                    //地址逆编码
                    var lnglatXY = [rs.data.lng, rs.data.lat]; //已知点坐标
                    self.regeocoder(lnglatXY);
                }).fail(function () {
                    alert("服务器出错");
                });
            }, 5000);
        }
    }, mounted : function () {
        this.init();
    }
});
