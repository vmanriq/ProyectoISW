import { api } from '../helpers';



function getAllCamas(estado) {
    return api.get(`CamasEstado?estado=${estado}`)
}

const camasService = {
	    getAllCamas,
	};

export default camasService;