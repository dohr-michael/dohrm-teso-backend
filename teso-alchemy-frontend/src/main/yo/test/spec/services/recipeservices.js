'use strict';

describe('Service: recipeServices', function () {

  // load the service's module
  beforeEach(module('tesoAlchemyApp'));

  // instantiate service
  var recipeServices;
  beforeEach(inject(function (_recipeServices_) {
    recipeServices = _recipeServices_;
  }));

  it('should do something', function () {
    expect(!!recipeServices).toBe(true);
  });

});
