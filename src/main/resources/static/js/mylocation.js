new Vue({
    el: '#rrapp',
    data: {
        list: [],
        p: {
            page: 1,
            limit: 15,
            total: 100
        },
    },
    methods: {
        select: function (selections) {
            this.selections = selections;
        },
        open :  function(){
            const h = this.$createElement;
            this.$notify({
                title: '标题名称',
                message: h('i', { style: 'color: teal'}, '这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案')
            });
        },
        open2 : function() {
            this.$notify({
                title: '提示',
                message: '这是一条不会自动关闭的消息',
                duration: 0
            });
        },
        reload: function (event) {
            var self = this;
            $.ajax({
                url: '../list',
                data: $.extend({}, self.p, self.q),
                type: 'post',
                dataType: 'json'
            }).done(function (rs) {
                if (rs.code == 500) {
                    alert(rs.msg);
                }
                self.list = rs.page.list;
                self.p.total = rs.page.totalCount;
            }).fail(function () {
                alert("服务器出错")
            })
        },
    },
    mounted: function () {//loaded vue
        this.reload();
    },

});