class Row extends React.Component {
notice= () =>
{
    var alert_= this.props.info.id
    alert(alert_)
}
render(){
    return (<button onClick={this.notice}>{this.props.info.id}</button>)
}
}