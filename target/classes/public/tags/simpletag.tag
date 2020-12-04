<simpletag>
<h2>default</h2>
<h1>{message1}</h1>
<h1>{message}</h1>

    this.message1 = opts.input
    this.message = opts.data
    var value = window.atob(opts.data)
    var reparced = JSON.parse(value)
    this.message=reparced.last_name


</simpletag>