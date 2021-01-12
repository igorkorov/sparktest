

class ButtonA extends React.Component{
method=()=>{
    alert('come method')
    var table = document.getElementById("root");
    const newDiv = document.createElement("div");
    newDiv.setAttribute("id", "144");
    const root1 = document.getElementById("root");
    root1.appendChild(newDiv);
    //document.body.insertBefore(newDiv, root1);
    ReactDOM.render(<h3>Dinamical rendered!</h3>, document.getElementById('144'));
}
render(){
    return  (    <button type="button"   onClick={this.method}>Comp A''</button>)

}
}