/**
 * 创建map类,用于存储键-值,一一对应起来
 */
function Map() {

    /**
     * 定义map类中的元素结构,并初始化
     */
    var struct = function (key, value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 定义put方法,添加元素
     */
    var put = function (key, value) {
        for (var i = 0; i < this.arr.length; i++) { //遍历map中的所有元素
            if (this.arr[i].key === key) { // 此map不能添加已经存在的元素
                this.arr[i].value == value;
                return false;
            }
        }
        this.arr[this.arr.length] = new struct(key, value);
    }

    /**
     * 定义get方法,根据key获取相应的value
     */
    var get = function (key) {
        for (var i = 0; i < this.arr.length; i++) {
            if (this.arr[i].key === key) {
                return this.arr[i].value;
            }
        }
        return null;
    }

    /**
     * 定义remove方法,用于删除指定key的元素
     */
    var remove = function (key) {
        var lastProp;
        for (var i = 0; i < this.arr.length; i++) {
            lastProp = this.arr.pop(); //移除最后一个元素并返回该元素值
            if (lastProp === key) {
                continue;
            }
            this.arr.unshift(lastProp); //将一个或多个新元素添加到数组开始，数组中的元素自动后移，返回数组新长度
        }
    }

    var size = function () {
        return this.arr.length;
    }

    this.arr = [];
    this.put = put;
    this.get = get;
    this.remove = remove;
    this.size = size;
}

function MapList() {

    /**
     * 定义map类中的元素结构,并初始化
     */
    var struct = function (key, value) {
        this.key = key;
        this.value = [];
        this.value.push(value);
    }

    /**
     * 定义put方法,添加元素
     */
    var put = function (key, value) {
        for (var i = 0; i < this.arr.length; i++) { //遍历map中的所有元素
            if (this.arr[i].key === key) { // 此map不能添加已经存在的元素
                this.arr[i].value.push(value);
                return false;
            }
        }
        this.arr[this.arr.length] = new struct(key, value);
    }

    /**
     * 定义get方法,根据key获取相应的value
     */
    var get = function (key) {
        for (var i = 0; i < this.arr.length; i++) {
            if (this.arr[i].key === key) {
                return this.arr[i].value;
            }
        }
        return null;
    }

    /**
     * 定义remove方法,用于删除指定key的元素
     */
    var remove = function (key) {
        var lastProp;
        for (var i = 0; i < this.arr.length; i++) {
            lastProp = this.arr.pop(); //移除最后一个元素并返回该元素值
            if (lastProp === key) {
                continue;
            }
            this.arr.unshift(lastProp); //将一个或多个新元素添加到数组开始，数组中的元素自动后移，返回数组新长度
        }
    }

    /**
     * 定义remove方法,用于删除指定key的元素
     */
    var removeItem = function (key, value) {
        var lastProp;
        for (var i = 0; i < this.arr.length; i++) {
            //lastProp = this.arr.pop(); //移除最后一个元素并返回该元素值
            if (this.arr[i].key === key) {
                this.arr[i].value.remove(value);
            }
            //this.arr.unshift(lastProp); //将一个或多个新元素添加到数组开始，数组中的元素自动后移，返回数组新长度
        }
    }

    var size = function () {
        return this.arr.length;
    }

    this.arr = [];
    this.put = put;
    this.get = get;
    this.remove = remove;
    this.removeItem = removeItem;
    this.size = size;

}

Array.prototype.remove = function (item) {
    var size = this.length;
    if (size > 0) {
        for (var i = 0; i < size; i++) {
            if (this[i] == item) {
                this.slice(i, 1);
                i--;
            }
        }
    }

}