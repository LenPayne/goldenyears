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
var EXPAND_TEXT = "<span class='glyphicon glyphicon-chevron-down'></span> See Complete List";
var HIDE_TEXT = "<span class='glyphicon glyphicon-chevron-up'></span> Hide Complete List";

var recApp = angular.module('recApp', ['ui.bootstrap-slider']);

recApp.controller('RecCtrl', function ($scope, $http) {
    $scope.expandText = EXPAND_TEXT;
    $scope.expand = false;
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
    };
});

recApp.filter('expandFilter', function() {
    return function (input) {
        if (input) return HIDE_TEXT;
        else return EXPAND_TEXT;
    }
})