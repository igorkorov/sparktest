<approvetag>
<div ref="container" align='center'>
<button ref = "btn" type="button" class="btn btn-success" onclick="{approve}">Разрешить </button><br><br>
<button ref = "btn2" type="button" class="btn btn-danger" onclick="{suppress}">Запретить''</button>
</div>
<script>
      this.on("mount",
      function() {
         this.refs.btn.onclick = function(e) {
           return false;
         };
         stat = opts.status

         if (stat!='SUSPENDING')
         {
            this.refs.container.disabled=true
            this.refs.btn2.disabled=true

            if (stat=='DENIED')
            {
                this.refs.container.innerHTML = "<h5 align='center'  style='color:red;'>Запрещено</h5>"
            }

            if (stat=='APPROVED')
            {
                this.refs.container.innerHTML = "<h5 align='center'  style='color:green'>Разрешено</h5>"
            }

         }

      })

      approve()
      {
        function getXmlHttp()
        {
            var xmlhttp;
            try {
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e)
            {
                try
                {
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (E)
                {
                    xmlhttp = false;
                }
            }
            if (!xmlhttp && typeof XMLHttpRequest!='undefined')
            {
                xmlhttp = new XMLHttpRequest();
            }
            return xmlhttp;
        }

        var xhr = getXmlHttp()
        var params= this.opts.number ;
        var request = "/approve?id="+params;
        xhr.open("GET", request, true);
        xhr.onreadystatechange=function()
        {
            if (xhr.readyState != 4) return
            clearTimeout(xhrTimeout)
            if (xhr.status == 200) {
                alert(xhr.responseText);
            }
        }

        xhr.send("a=5&b=4");
        var xhrTimeout = setTimeout( function(){ xhr.abort(); handleError("Timeout") }, 10000);

        function handleError(message)
        {
            alert("Ошибка: "+message)
        }
      }

      suppress()
      {
        alert('supress req'+this.opts.number)
      }

</script>
</approvetag>