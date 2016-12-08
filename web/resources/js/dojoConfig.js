/**
 * Created by Денис on 08.12.2016.
 */

var dojoConfig;
(function () {
    var baseUrl = location.pathname.replace(/\/[^/]+$/, '/'),
        dgridUrl = baseUrl + '../../../../js/';
    dojoConfig = {
        async: 1,
        cacheBust: '20160108',
        // Load dgrid and its dependencies from a local copy.
        // If we were loading everything locally, this would not
        // be necessary, since Dojo would automatically pick up
        // dgrid as a sibling of the dojo folder.
        packages: [
            { name: 'dgrid', location: dgridUrl + 'dgrid' },
            { name: 'dstore', location: dgridUrl + 'dstore' }
        ]
    };
}());