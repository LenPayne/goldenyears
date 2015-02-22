/* 
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


var recApp = angular.module('recApp', []);

recApp.controller('RecCtrl', function ($scope, $http) {
    $scope.stress = 33;
    $scope.health = 33;
    $scope.cost = 33;    
    $scope.predicate = '';
    $scope.reverse = false;
    $http.get('q/recommendation').success(function (data) {
        $scope.cities = data;
    });

    $scope.refresh = function () {
        $http.get('q/recommendation/' + $scope.stress + '/' + $scope.health + '/' + $scope.cost).success(function (data) {
            $scope.cities = data;
        });
    }
});