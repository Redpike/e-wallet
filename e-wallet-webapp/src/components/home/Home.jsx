import React from "react";
import MuiThemeProvider from "material-ui/styles/MuiThemeProvider";
import Drawer from "material-ui/Drawer";
import MenuItem from "material-ui/MenuItem";
import {AppBar, IconButton} from "material-ui";
import {NavigationClose} from "material-ui/svg-icons/index";
import {Footer} from "react-materialize";

const Home = props => (
    <div style={{height: "100%", display: "flex", flexDirection: "column"}}>
        <MuiThemeProvider>
            <Drawer open={true}>
                <MenuItem>Menu Item</MenuItem>
                <MenuItem>Menu Item 2</MenuItem>
            </Drawer>
            <AppBar
                style={{flex: "0 64px"}}
                title="Title"
                iconElementLeft={<IconButton><NavigationClose /></IconButton>}
            />
            <div style={{flex: "1 auto"}}/>
            <Footer copyrights="&copy 2015 Copyright Text"
                    moreLinks={
                        <a className="grey-text text-lighten-4 right" href="#!">More Links</a>
                    }
                    links={
                        <ul>
                            <li><a className="grey-text text-lighten-3" href="#!">Link 1</a></li>
                            <li><a className="grey-text text-lighten-3" href="#!">Link 2</a></li>
                            <li><a className="grey-text text-lighten-3" href="#!">Link 3</a></li>
                            <li><a className="grey-text text-lighten-3" href="#!">Link 4</a></li>
                        </ul>
                    }
                    className='example'
                    style={{flex: "0 40px"}}
            >
                <h5 className="white-text">Footer Content</h5>
                <p className="grey-text text-lighten-4">You can use rows and columns here to organize your footer
                    content.</p>
            </Footer>
        </MuiThemeProvider>
    </div>
);
export default Home