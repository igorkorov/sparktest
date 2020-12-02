  <buttontag>
        <button ref = "btn" type="button" class="btn btn-danger">Danger</button>
 <script>
      this.on("mount", function() {
         this.refs.btn.onclick = function(e) {
           alert('button clicked');
            return false;
         };

      })
   </script>

  </buttontag>