<approvetag>
<button ref = "btn" type="button" class="btn btn-success">Разрешить </button><br><br>
<button ref = "btn2" type="button" class="btn btn-danger">Запретить''</button>
<script>
      this.on("mount", function() {
         this.refs.btn.onclick = function(e) {
           approve();
           return false;
         };
      })

      function approve(){
        alert('запрос № '+opts.number+' разрешен');
      }
   </script>
</approvetag>