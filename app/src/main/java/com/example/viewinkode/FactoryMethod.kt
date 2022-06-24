package com.example.viewinkode

class FactoryMethod {
}

abstract class Coffee {
    fun makeCoffee() {
        // делаем кофе
    }

    fun pourIntoCup() {
        // наливаем в чашку
    }
}

abstract class CoffeeShop {
    fun orderCoffee(type: CoffeeType?): Coffee? {
        val coffee = createCoffee(type)
        coffee?.makeCoffee()
        coffee?.pourIntoCup()
        println("Вот ваш кофе! Спасибо, приходите еще!")
        return coffee
    }

    protected abstract fun createCoffee(type: CoffeeType?): Coffee?
}

class ItalianCoffeeShop : CoffeeShop() {
    override fun createCoffee(type: CoffeeType?): Coffee? {
        var coffee: Coffee? = null
        when (type) {
            CoffeeType.AMERICANO -> coffee = ItalianStyleAmericano()
            CoffeeType. ESPRESSO -> coffee = ItalianStyleEspresso()
            CoffeeType.CAPPUCCINO -> coffee = ItalianStyleCappuccino()
            CoffeeType. CAFFE_LATTE -> coffee = ItalianStyleCaffeLatte()
        }
        return coffee
    }
}

enum class CoffeeType {
    ESPRESSO, AMERICANO, CAFFE_LATTE, CAPPUCCINO
}
class AmericanCoffeeShop : CoffeeShop() {
    override fun createCoffee(type: CoffeeType?): Coffee? {
        var coffee: Coffee? = null
        when (type) {
            CoffeeType.AMERICANO -> coffee = AmericanStyleAmericano()
            CoffeeType.ESPRESSO -> coffee = AmericanStyleEspresso()
            CoffeeType.CAPPUCCINO -> coffee = AmericanStyleCappuccino()
            CoffeeType.CAFFE_LATTE -> coffee = AmericanStyleCaffeLatte()
        }
        return coffee
    }
}
class ItalianStyleAmericano : Coffee()
class ItalianStyleCappuccino : Coffee()
class ItalianStyleCaffeLatte : Coffee()
class ItalianStyleEspresso : Coffee()

class AmericanStyleAmericano : Coffee()
class AmericanStyleCappuccino : Coffee()
class AmericanStyleCaffeLatte : Coffee()
class AmericanStyleEspresso : Coffee()

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val italianCoffeeShop: CoffeeShop = ItalianCoffeeShop()
        italianCoffeeShop.orderCoffee(CoffeeType.CAFFE_LATTE)
        val americanCoffeeShop: CoffeeShop = AmericanCoffeeShop()
        americanCoffeeShop.orderCoffee(CoffeeType.CAFFE_LATTE)
    }
}