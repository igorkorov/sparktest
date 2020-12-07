      function approve(){
        alert('запрос № '+opts.number+' разрешен');
        var socket = new WebSocket("ws://localhost:4567/echo");
        alert('start socket with babel');
        // отправить сообщение из формы publish
        socket.send(opts.number);


        // обработчик входящих сообщений
        socket.onmessage = function(event) {
            alert(event.data);
        };
      }