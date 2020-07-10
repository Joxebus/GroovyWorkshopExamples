package io.github.joxebus.groovy.example2

/**
 * This example tests different expressions
 * the last one shows an Assetion Failed
 * this is a PowerAssert which contains some
 * additional information to make easier
 * to know where is the error in a test.
 */

def range = 0..5
assert (0..5).collect() == [0, 1, 2, 3, 4, 5]
assert (0..<5).collect() == [0, 1, 2, 3, 4]
assert (0..5) instanceof List
assert 0..5 instanceof Range
assert (0..5).size() == 6
assert (0..5).size() == 5
