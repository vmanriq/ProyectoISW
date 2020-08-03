import React,{Component } from "react";
import { Container, Row, Col, Card, CardHeader, CardBody } from "shards-react";
import camasService from '../services/camas.service';
class Tables extends Component{
	
	constructor(props){
		super(props);
		this.state = {
				camas: [],
				estado: false,	
		}
	}
	
	
	
	//Para extraer las camas, en el servicio se deberia crear uno para filtrar por pabellon
	//Este es el primero que se carga asi que parte con el All y por default las no ocupadas
	componentDidMount(){
		camasService.getAllCamas(this.state.estado)
		.then((response)=>{
			this.setState({
				...this.state,
				camas: response.data,
			})
			console.log("camas",this.state.camas);
			console.log("estado",this.state.estado);
		})
		
	}
	//Para extraer las camas, en el servicio se deberia crear uno para filtrar por pabellon
	//En este abria que crear un if que use el getAll o el por pabellon
	  componentDidUpdate(prevProps, prevState) {
		  if(prevState.estado !== this.state.estado) {
		  camasService.getAllCamas(this.state.estado)
			.then((response)=>{
				this.setState({
					...this.state,
					camas: response.data,
				})
				console.log("camas",this.state.camas);
				console.log("estado",this.state.estado);
			})}
	  }
	
	
	
	render() {
	    const { camas } = this.state;
	    //La parte que alimenta la tabla segun el json obtenido
	    const renderCama = (cama,index)=>{
	    	var est;
	    	//Por alguna razon el false no se muestra en la tabla asi que lo pase a si o no
	    	if (cama.ocupado===false){
	    		est='No';
	    	}
	    	else{
	    		est='Si'
	    	}	    	
			return(
					<tr key={index}>
						<td>{cama.camaid}</td>
						<td>{cama.idpabellon}</td>
						<td>{est}</td>
						<td>{cama.capacidad}</td>
					</tr>
					)
		}

	    return (
	    		//La tabla hay que añadirle los dropdowns de estado y pabellon
	    		<Container fluid className="main-content-container px-4">
	    	    {/* Default Light Table */}
	    	    <Row>
	    	      <Col>
	    	        <Card small className="mb-4">
	    	          <CardHeader className="border-bottom">
	    	          <tr>
	    	          	<th scope="col" className="border-0">
	    	            <h6 className="m-0">Listado de Camas</h6>
	    	            </th>
	    	         <td>
	                    <div class="dropdown">
	                        <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                            Ocupada
	                        </button>
	                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	                            <a class="dropdown-item"    onClick = {() => this.setState({...this.state,
	                    																			estado: true,})}>Si</a>
	                    		<a class="dropdown-item"    onClick = {() => this.setState({...this.state,
	 		                    																	estado: false,})}>No</a>
	                        </div>
	                    </div>
	                </td>
	    	          </tr>
	    	          </CardHeader>
	    	          <CardBody className="p-0 pb-3">
	    	            <table className="table mb-0">
	    	              <thead className="bg-light">
	    	                <tr>
	    	                  <th scope="col" className="border-0">
	    	                    Id Cama
	    	                  </th>
	    	                  <th scope="col" className="border-0">
	    	                    Id Pabellon
	    	                  </th>
	    	                  <th scope="col" className="border-0">
	    	                    Ocupado
	    	                  </th>
	    	                  <th scope="col" className="border-0">
	    	                    Capacidad
	    	                  </th>
	    	                </tr>
	    	              </thead>
	    	              <tbody>
	    	                {camas.map(renderCama)}
	    	              </tbody>
	    	            </table>
	    	          </CardBody>
	    	        </Card>
	    	      </Col>
	    	    </Row>
	    	  </Container>
	    );
	  }
}





export default Tables;
