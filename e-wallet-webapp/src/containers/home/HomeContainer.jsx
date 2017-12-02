import React, {PureComponent} from "react";
import {connect} from "react-redux";
import {getAllUsers} from "../../redux/home/home"
import Home from "../../components/home/Home.jsx";

class HomeContainer extends PureComponent {
    render() {
        return (
            <Home {...this.props}/>
        );
    }
}

const mapStateToProps = ({home}) => ({
    users: home.users
});

const mapDispatchToProps = dispatch => ({
    getAllUsers: (callback) => {
        dispatch(getAllUsers(callback));
    }
});

export default connect(mapStateToProps, mapDispatchToProps)(HomeContainer)