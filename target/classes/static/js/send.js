new Vue({
    el: "#app",
    data: {
        base: $('#base').attr('href') + "/",
        msg: null
    },
    create: {

    },
    watch: {

    },
    methods: {
        send: function () {
            var msgs = [];
            msgs.push(this.msg);
            $.ajax({
                url : this.base+"producer",
                data : {msgs:msgs},
                success : function (data) {

                }
            });
        }
    }, mounted: function () {
    }
});
