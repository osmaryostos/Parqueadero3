//'use strict';

/*
VANILLA JS
*/
const el = document.createElement('h1');
const child = document.createElement('span');
el.setAttribute('id','title');
el.textContent = 'Parqueadero';
child.textContent = 'Mundo';
el.appendChild(child);
document.getElementById('app').appendChild(el);


/*
react JS
*/

/*const el = React.createElement('h1',{id:'title'},'Hola Mundo =)',
React.createElement('span',null, ' Mundo'));
ReactDOM.render(el,document.getElementById('app'));
*/
/*
react JSX
*/
/*const el = (<h1 id="title" className="title">
Holas {2 + 5} <span>Mundo</span>
</h1>);
ReactDOM.render(el,document.getElementById('app'));*/
/*var app = document.getElementById('app');

function reloj() {
    // app.textContent = new Date().toLocaleTimeString();
    var now = new Date().toLocaleTimeString();
    var el = React.createElement(
        'span',
        null,
        now
    );
    ReactDOM.render(el, app);
}

//setInterval(reloj,1000);

function Saludar(props) {
    return React.createElement(
        'h1',
        null,
        'Hola',
        props.name
    );
}
ReactDOM.render(React.createElement(
    'div',
    null,
    React.createElement(Saludar, { name: 'Alexys' }),
    React.createElement(Saludar, { name: 'Carlos' }),
    React.createElement(Saludar, { name: 'Jose' })
), document.getElementById('app'));
*/