import Api from "../../api/api";

export const GET_ALL_USERS = "GET_ALL_USERS";

export const getAllUsers = (callback = () => {}) => dispatch => {
    Api.getAllUsers().then((response) => {
        if (response.ok) {
            response.json().then((users) => {
                dispatch({
                    type: GET_ALL_USERS,
                    payload: {
                        users
                    }
                });
            });
        }

        callback(response);
    });
};

const initialState = {
    users: []
};

export default function homeReducer(state = initialState, { type, payload }) {
    if (type === GET_ALL_USERS) {
        state = {
            ...state,
            users: payload.users
        };
    }
    return state;
}
