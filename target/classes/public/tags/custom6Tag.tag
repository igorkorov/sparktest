<custom6Tag>
   <form ref = "customForm">
      <input ref = "username" type = "text" value = "Mahesh"/>
      <button ref = "clickButton">Click MeCustom6Tag!</button>
      <input type = "submit" value = "Submit" />
   </form>
   <script>
      this.on("mount", function() {
         this.refs.clickButton.onclick = function(e) {
            console.log("clickButton clicked");
            return false;
         };
         this.refs.customForm.onsubmit = function(e) {
            alert("Form submitted");
            return false;
         };
      })
   </script>
</custom6Tag>