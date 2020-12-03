<buttontag>
    <div ref = "div1"><h1 ref = "h1">{message}</h1><br><h1>description</h1></div>
    <p ref='paragraph' onclick={onClick}>{message}</p>
    <button ref = "btn" type="button" class="btn btn-danger" onclick={call}>Danger</button>
    <script>
        if (opts.base != undefined){
            var base = opts.base
            alert('base not null')
            var value = window.atob(base)
            alert(value)
            var reparced = JSON.parse(value)
            alert('last name@base'+reparced.last_name)
        }

        call()
        {
            alert('script')
            this.message = '121212'
            this.refs.div1.innerHTML = this.message
            this.refs.div1.innerHTML = '<h1>Абзац<br><br><a href="https://google.com">link</a></h1>'
        }

        onClick()
        {
            alert('check')
            this.message = 'hello2'
            this.refs.paragraph.innerHTML = this.message
        }



</script>
</buttontag>