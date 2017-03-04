angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http({
                method: 'GET',
                url: 'http://192.168.8.7:8080/hk-web-master/module/all'
               
            }).then(function mySucces(response) {
                console.log(response);


            }, function myError(response) {
                console.log(response);
            });
});