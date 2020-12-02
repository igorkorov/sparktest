<custom11Tagm>
<h1 ref="h1">{ output }</h1>
<button ref = "btn" type="button" class="btn btn-danger" onclick={onClick}>Updated</button>
 <script>
    updater(){
         output = 'updated'
    }
    this.output = opts.start
    this.output = '12121'+6767
    this.on("mount", function() {


   })

 onClick() {
            alert('check')
            this.message = 'hello2'
            this.refs.h1.innerHTML = '<b>Updated!</b>';

   }
   </script>

</custom11Tagm>