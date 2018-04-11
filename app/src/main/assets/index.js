function connectWebViewJavascriptBridge(callback) {
        if (window.WebViewJavascriptBridge) {
            callback(WebViewJavascriptBridge)
        } else {
            document.addEventListener(
                'WebViewJavascriptBridgeReady'
                , function() {
                    callback(WebViewJavascriptBridge)
                },
                false
            );
        }
    }
    connectWebViewJavascriptBridge(function(bridge) {
//        bridge.init(function(message, responseCallback) {
//        console.log('JS got a message', message);
//           alert(message);
//            responseCallback(data);
//        });
        bridge.registerHandler("functionInJs", function(data, responseCallback) {
                document.getElementById("show").innerHTML = "Native发来的消息是：" + data;
                var responseData = "Javascript Says Right back aka!";
                responseCallback(responseData);
            });
    })
    function go(){
    //给android 发送消息
            window.WebViewJavascriptBridge.callHandler(
                "Android",
                "Hello",
                function(responseData){
                    document.getElementById("show").innerHTML = "Native给我的数据:"+responseData;
                }
            );
        }

