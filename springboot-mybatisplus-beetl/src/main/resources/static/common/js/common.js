function openDialog(title,contentOrUrl){
    layer.open({
        title: title
        ,content: contentOrUrl
    });
}
//自定义 jquery方法
(function($){
    //序列化json   如form转json
    $.fn.serializeJson = function(){
        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(
            function() {
                if (serializeObj[this.name]) {
                    if ($.isArray(serializeObj[this.name])) {
                        serializeObj[this.name].push(this.value);
                    } else {
                        serializeObj[this.name] = [
                            serializeObj[this.name], this.value ];
                    }
                } else {
                    serializeObj[this.name] = this.value;
                }
            });
        return serializeObj;
    }

}(jQuery));