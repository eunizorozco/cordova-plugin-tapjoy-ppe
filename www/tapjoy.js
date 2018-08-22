/*global cordova, module*/

module.exports = {
    connect: function (key, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "TapJoyPPE", "connect", [key]);
    }
};
