/**
 * 
 */
const app = document.getElementById('app')

function reloj(){
   // app.textContent = new Date().toLocaleTimeString();
   let now = new Date().toLocaleTimeString();
   const el  = <span>{now}</span>;
   ReactDOM.render(el,app);
}

//setInterval(reloj,1000);

function Saludar(props){
    return <h1>Hola{props.name}</h1>;
}
ReactDOM.render(
    <div>
<Saludar name = 'Alexys' />
<Saludar name = 'Carlos' />
<Saludar name = 'Jose' />
</div>
,document.getElementById('app'));