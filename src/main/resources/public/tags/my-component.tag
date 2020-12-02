<my-component>
  <p ref='paragraph' onclick={onClick}>{message}</p>

  <!-- optional <script> tag -->

    this.on('mount', function() {
        this.message="default"
        this.refs.paragraph.innerHTML = '<b>hello</b>'+this.message
    })
    onClick() {
            alert('check')
            this.message = 'hello2'
            this.refs.paragraph.innerHTML = this.message

   }
</my-component>
