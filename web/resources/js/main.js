/**
 * Created by Денис on 05.12.2016.
 */

require([
    "dojo/_base/window", "dojo/store/Memory",
    "dijit/tree/ObjectStoreModel", "dijit/Tree",
    "dojo/domReady!"
], function(win, Memory, ObjectStoreModel, Tree){

    // Create test store, adding the getChildren() method required by ObjectStoreModel
    var myStore = new Memory({
        data: [
            { id: 'world', name:'The earth', type:'planet', population: '6 billion'},
            { id: 'AF', name:'Africa', type:'continent', population:'900 million', area: '30,221,532 sq km',
                timezone: '-1 UTC to +4 UTC', parent: 'world'},
            { id: 'EG', name:'Egypt', type:'country', parent: 'AF' },
            { id: 'KE', name:'Kenya', type:'country', parent: 'AF' },
            { id: 'Nairobi', name:'Nairobi', type:'city', parent: 'KE' },
            { id: 'Mombasa', name:'Mombasa', type:'city', parent: 'KE' },
            { id: 'SD', name:'Sudan', type:'country', parent: 'AF' },
            { id: 'Khartoum', name:'Khartoum', type:'city', parent: 'SD' },
            { id: 'AS', name:'Asia', type:'continent', parent: 'world' },
            { id: 'CN', name:'China', type:'country', parent: 'AS' },
            { id: 'IN', name:'India', type:'country', parent: 'AS' },
            { id: 'RU', name:'Russia', type:'country', parent: 'AS' },
            { id: 'MN', name:'Mongolia', type:'country', parent: 'AS' },
            { id: 'OC', name:'Oceania', type:'continent', population:'21 million', parent: 'world'},
            { id: 'EU', name:'Europe', type:'continent', parent: 'world' },
            { id: 'DE', name:'Germany', type:'country', parent: 'EU' },
            { id: 'FR', name:'France', type:'country', parent: 'EU' },
            { id: 'ES', name:'Spain', type:'country', parent: 'EU' },
            { id: 'IT', name:'Italy', type:'country', parent: 'EU' },
            { id: 'NA', name:'North America', type:'continent', parent: 'world' },
            { id: 'SA', name:'South America', type:'continent', parent: 'world' }
        ],
        getChildren: function(object){
            return this.query({parent: object.id});
        }
    });

    // Create the model
    var myModel = new ObjectStoreModel({
        store: myStore,
        query: {id: 'world'}
    });

    // Create the Tree.
    var tree = new Tree({
        model: myModel
    });
    tree.placeAt(win.body());
    tree.startup();
});



dojo.require("dijit.layout.BorderContainer");
dojo.require("dijit.layout.TabContainer");
dojo.require("dijit.layout.ContentPane");

dojo.require("dojo.data.ItemFileWriteStore");
dojo.require("dijit.Tree");


dojo.ready(function(){
    var appLayout = new dijit.layout.BorderContainer({
        design: "headline"
    }, dojo.byId("appLayout"));

    var contentTabs = new dijit.layout.TabContainer({
        region: "center",
        id: "contentTabs",
        tabPosition: "bottom",
        "class": "centerPanel",
        href: "contentCenter.html"
    });

    appLayout.addChild(contentTabs);

    var topPane = new dijit.layout.ContentPane({
        region: "top",
        "class": "edgePanel",
        content: "Header content (top)"
    });

    appLayout.addChild(topPane);

    var store = new dojo.data.ItemFileWriteStore({
        data:continentData
    });

    var treeModel = new dijit.tree.ForestStoreModel({
        store:store,
        query:{
            "type":"continent"
        },
        rootId:"root",
        rootLabel:"Continents",
        childrenAttrs:["children"]
    });

    var contentTree = new dijit.Tree({
        model:treeModel,
        persist:false,
        showRoot:false,
        getIconClass:function(item, opened){
            console.log('tree getIconClass', item, opened);

            //console.log('tree item type', store.getValue(item, 'type'));
            console.log('tree item type', item.type);
        }
    });

    dojo.connect(contentTree, "onClick", function(item, node, evt){
        console.log('content tree clicked', item, node, evt);
    });
    var leftPane = new dijit.layout.ContentPane({
        region:"left",
        id:"leftCol",
        "class":"edgePanel",
        content:"Sidebar content (left)",
        splitter:true
    });

    leftPane.addChild(new dijit.layout.ContentPane({region:'center',content:contentTree}));

    appLayout.addChild(leftPane);



    var tryButton = dojo.create('button',{innerHTML:'try'});
    var paneLayout = new dijit.layout.BorderContainer({design:'headline'});
    paneLayout.addChild(new dijit.layout.ContentPane({region:'top',content:tryButton}));



    var counter = 0;

    function dynamicallyUpdateStoreAndTree() {
        counter++;
        store.newItem({ id: counter, name:('Fake'+counter), type:'continent'});
    }

    function openLeafInTree() {
        //dojo.set(contentTree, "selectedItems", []);
        contentTree.set('paths', [['children', 'AS']]);
    }

    dojo.connect(tryButton, "onclick", function(){
        //dynamicallyUpdateStoreAndTree();
        openLeafInTree();
    });

    var contentPane = new dijit.layout.ContentPane({
        content:paneLayout,
        title:"Group 1"
    });

    //contentPane2.set("content", contentTree);

    var contentPane2 = new dijit.layout.ContentPane({
        content:"Group 2 content",
        title:"Group 2"
    });

    contentTabs.addChild(contentPane);
    contentTabs.addChild(contentPane2);

    dojo.connect(contentTabs, "selectChild", function(child){
        console.log('panel change', child);
    });

    dojo.connect(contentTabs, "_transition", function(selectedChild, deselectedChild){
        console.log('panel transition', selectedChild.title, deselectedChild.title);
    });

    appLayout.startup();
});

var continentData = {
    identifier: 'id',
    label: 'name',
    items: [
        {   id: 'AF',
            name:'Organizations',
            type:'continent',
            population:'900 million',
            area: '30,221,532 sq km',
            timezone: '-1 UTC to +4 UTC',
            children:[
                {_reference:'Divisions'},
                {_reference:'Employees'}
            ]
        },
        { id: 'Employees', name:'Employees', type:'country' },
        { id: 'Divisions', name:'Divisions', type:'country',
            children:[
                {_reference:'Nairobi'},
                {_reference:'Mombasa'}
            ]
        },
        { id: 'AS', name:'Orders', type:'continent',
            children:[
                {_reference:'toExecute'},
                {_reference:'Given'}
            ]
        },
        { id: 'toExecute', name:'To execute', type:'country' },
        { id: 'Given', name:'Given', type:'country' }
    ]};

