import { api } from '../helpers';



function getAllCamas(estado,idpabellon) {
    return api.get(`CamasEstadoPabellon?estado=${estado}&idpabellon=${idpabellon}`)
}

function getAllIds() {
    return api.get(`PabellonIds`)
}

const camasService = {
		getAllCamas,
		getAllIds,
	};

export default camasService;