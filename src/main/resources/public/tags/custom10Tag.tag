<custom10Tag>
   <button onclick = {sendMessage}>Custom 10</button>
   <p ref="h1">{ output }</p>
   <script>
      this.output = "000"+ opts.start
      sendMessage() {
         riot.eventBus.trigger('message', 'Custom 10 Button Clicked!');
      }

       riot.eventBus.on('message2', function(input) {
               alert(input);
               console.log(input);
            });
   </script>
</custom10Tag>