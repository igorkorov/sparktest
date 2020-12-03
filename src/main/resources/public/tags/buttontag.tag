<buttontag>
    <div ref = "div1"><h1 ref = "h1">{message}</h1><br><h1>description</h1></div>
    <p ref='paragraph' onclick={onClick}>{message}</p>
    <button ref = "btn" type="button" class="btn btn-danger" onclick={call}>Danger</button>
    this.on("mount", function() {
        alert('page loaded!')
    })
    <script>


        call()
        {
            alert('script')
            this.message = '121212'
            this.refs.div1.innerHTML = this.message
            this.refs.div1.innerHTML = '<h1>Абзац<br><br><a href="https://google.com">link</a></h1>'
            if (opts.base64 != undefined){
                var base = opts.base64
                alert('base not null')
                var value = window.atob(base)
                alert(value)
                var reparced = JSON.parse(value)
                var result =  'Дата: '+ reparced.Date +'<br>'
                result +=  'Время: '+ reparced.Time +   '<br>'
                result +=  'Номер накладной: '+ reparced.Waybill_number +    '<br>'
                result +=  'Металл: '+ reparced.Metall +    '<br>'
                result +=  'Тара: '+ reparced.Tara +    '<br>'
                result +=  'Нетто: '+ reparced.Netto +   '<br>'
                result +=  'Брутто: '+ reparced.Brutto +   '<br>'
                result +=  'Засор: '+ reparced.Clogging +   '<br>'
                result +=  'Примесь: '+ reparced.Trash +   '<br>'
                this.refs.paragraph.innerHTML = result



                    //    {"Date": "2020-11-05", "Mode": "Приемка", "Tara": "0.0", "Time": "14:16:26", "Netto": "0.99", "Trash": "0.1", "Brutto": "1.1", "Metall": "Нержавейка", "Comment": "войт", "Clogging": "1.0", "Complete": "Да", "Condition": "Выгружен", "Waybill_number": "8"}


            }
        }

        onClick()
        {
            alert('check')
            this.message = 'hello2'
            this.refs.paragraph.innerHTML = this.message
        }



</script>
</buttontag>