new Vue({
    el: "#app",
    data: {
        base: $('#base').attr('href') + "/",
        codePrefix: '获取验证码',
        code: null,
        disClass: false,
        tel: null
    },
    create: {

    },
    watch: {
        'tel': function (val) {
            if (!val.match(/^1[3|4|5|7|8][0-9]{9}$/)) {
                this.disClass = true;
            }else{
                this.disClass = false;
            }
        }
    },
    methods: {
        regCode: function () {
            if (this.disClass) {
                return;
            }
            var self = this;
            self.code = 60;
            this.disClass = true;
            self.codePrefix = 's后重新发送';
            var timeOut = setInterval(function () {
                self.code--;
                if (self.code == 0) {
                    clearInterval(timeOut);
                    self.code = null;
                    self.disClass = false;
                    self.codePrefix = '重新发送';
                }
            }, 1000);
        },
        init: function () {
        }
    }, mounted: function () {
        this.init();
    }
});
