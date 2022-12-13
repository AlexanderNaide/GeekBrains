angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.addProduct = function () {
        $http.post(contextPath + '/add_product', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts();
            });
    };

    $scope.deleteProduct = function (ProductID) {
        $http.get(contextPath + '/delete_product/' + ProductID)
            .then(function (response) {
                $scope.loadProducts();
            });
    };

    $scope.loadProducts();
});