class Simple extends React.Component {
showMessage= () =>{
    console.log( 'Всем привет!' );
}
render(){
    return <p>{this.props.number}</p>

}
}