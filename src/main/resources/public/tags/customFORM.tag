<customFORM>
   <form action='getriot'>
      <input ref = "username" type = "text" value = "Mahesh" name="value"/>
      <input type = "submit" value = "Click Me!" />
   </form>
   <script>
      this.on("mount", function() {
         console.log("Mounting");
         console.log(this.refs.username.value);
      })
   </script>
</customFORM>