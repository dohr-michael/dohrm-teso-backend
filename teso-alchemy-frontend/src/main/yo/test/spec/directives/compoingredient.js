'use strict';

describe('Directive: compoIngredient', function () {

  // load the directive's module
  beforeEach(module('tesoAlchemyApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<compo-ingredient></compo-ingredient>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the compoIngredient directive');
  }));
});
