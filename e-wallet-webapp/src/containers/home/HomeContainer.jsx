import React, {PureComponent} from "react";
import {push} from "react-router-redux";
import {bindActionCreators} from "redux";
import {connect} from "react-redux";
import {decrement, decrementAsync, increment, incrementAsync} from "../../modules/counter";
import Home from "../../components/home/Home.jsx";

class HomeContainer extends PureComponent {
    render() {
        return (
            <Home {...this.props}/>
        );
    }
}

const mapStateToProps = state => ({
    count: state.counter.count,
    isIncrementing: state.counter.isIncrementing,
    isDecrementing: state.counter.isDecrementing
});

const mapDispatchToProps = dispatch => bindActionCreators({
    increment,
    incrementAsync,
    decrement,
    decrementAsync,
    changePage: () => push('/about-us')
}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(HomeContainer)