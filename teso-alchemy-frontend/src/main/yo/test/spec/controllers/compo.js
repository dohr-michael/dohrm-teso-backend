'use strict';

describe('Controller: CompoCtrl', function () {

  // load the controller's module
  beforeEach(module('tesoAlchemyApp'));

  var CompoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CompoCtrl = $controller('CompoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
