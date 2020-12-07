<approvetag>
<div ref="container" align='center'>
<button ref = "btn" type="button" class="btn btn-success">Разрешить </button><br><br>
<button ref = "btn2" type="button" class="btn btn-danger">Запретить''</button>
</div>
<script>
      this.on("mount", function() {
         this.refs.btn.onclick = function(e) {
           approve();
           return false;
         };

         if (opts.status!='SUSPENDING'){
            this.refs.container.disabled=true
            this.refs.btn2.disabled=true
            if (opts.status!='DENIED')
                this.refs.container.innerHTML = "<h5 align='center'  style='color:red;'>Запрещено</h5>"
            if (opts.status!='APPROVED')
                this.refs.container.innerHTML = "<h5 align='center'  style='color:green'>Разрешено</h5>"
         }
      })

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
   </script>
</approvetag>