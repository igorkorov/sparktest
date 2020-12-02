<custom11Tag>
   <script>
      riot.eventBus.on('message', function(input) {
         alert(input);
         console.log(input);
         riot.eventBus.trigger('message2', 'message received');
         any(input);
      });

      function any(input){
        alert('any')
        const h4 = document.createElement('h4')
        const a = document.createElement('a')
        const img = document.createElement('img')
        const body = document.querySelector('body');
        body.append(h4)
        h4.innerHTML = input
      }
   </script>
</custom11Tag>