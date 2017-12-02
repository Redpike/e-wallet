export const API_SERVER = "http://localhost:8080";

class Api {
    constructor() {
        this.getAllUsers = this.getAllUsers.bind(this);
    }

    getAllUsers() {
        return fetch(`${API_SERVER}/api/user`, {
            method: "GET"
        });
    }
}

export default new Api();
