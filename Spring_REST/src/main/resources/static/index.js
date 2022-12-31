angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/products';
    let number = 1;
    let totalNumber;

    $scope.updateProducts = function () {
        let min;
        let max;
        let bF;
        let cat;
        if (document.getElementById("selectCat").valueOf().value !== "null"){
            cat = document.getElementById("selectCat").valueOf().value;
        }

        if ($scope.filter !== null){
            bF = true;
            min = $scope.filter.min !== null ? $scope.filter.min : null;
            max = $scope.filter.max !== null ? $scope.filter.max : null;
        }
        // cat = document.getElementById("selectCat").valueOf().value;
        $http({
            url: contextPath,
            method: 'POST',
            params: {
                val: $scope.value !== null ? $scope.value : null,

                min: bF ? min : null,
                max: bF ? max : null,
                cat: cat,
                page: number
            }
        }).then(function (response) {
            $scope.pagination(response);
            $scope.ProductsList = response.data.content;
            // console.log($scope.ProductsList)
            // console.log(response.data);
            });
    };

    $scope.loadProducts = function () {
        $http({
            url: contextPath,
            method: 'GET'
        }).then(function (response) {
            $scope.pagination(response);
            $scope.ProductsList = response.data.content;

                // console.log($scope.ProductsList)
        });
    };

    $scope.categories = function () {
        $http({
            url: contextPath + "/categories",
            method: 'GET'
        }).then(function (response) {
            $scope.CategoriesList = response.data;
        });
    };

    $scope.searchForm = function () {
        $scope.updateProducts();
    };

    $scope.addFilter = function () {
        number = 1;
        $scope.updateProducts();
    };

    $scope.resetFilter = function () {
        $scope.filter = null;
        $scope.updateProducts();
    };

    $scope.pagination = function (response) {
        totalNumber = response.data.totalPages;
        $scope.first = response.data.first === true ? 'disabled' : null;
        $scope.last = response.data.last === true ? 'disabled' : null;

        $scope.page1 = response.data.number + 1;
        // $scope.page2 = response.data.number + 2;
        // $scope.page3 = response.data.number + 3;
        // $scope.page4 = response.data.number + 4;
        // $scope.page5 = response.data.number + 5;

    };

    $scope.pageClick = function (delta) {
        // console.log(delta);
        number = number + delta;
        $scope.updateProducts();
    };

    $scope.pageStart = function () {
        number = 1;
        $scope.updateProducts();
    };

    $scope.pageFinish = function () {
        number = totalNumber;
        $scope.updateProducts();
    };

    $scope.filter = null;
    $scope.loadProducts();
    $scope.categories();

});