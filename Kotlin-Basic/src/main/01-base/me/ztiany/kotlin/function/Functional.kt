package me.ztiany.kotlin.function

import java.io.File

/**
 *  **函数式编程**：定义“函数式编程”不是一件容易的事情，因为业界对于所谓的“函数式编程”有着不同的标准。
 *
 *  其实，我们可以从狭义和广义两个方面去解读所谓的函数式语言。
 *
 *  所谓**狭义的函数式语言**，有着非常简单且严格的语言标准，即只通过纯函数进行编程，不允许有副作用。然而，
 *  纯函数式的编程语言也有着一些明显的劣势，典型的就是绝对的无副作用，以及所有的数据结构都是不可变的。
 *  这使得它在设计一些如今我们认为非常简单的程序的时候，也变得十分麻烦，如实现一个随机数函数。因此，站在纯函
 *  数式语言肩膀上发展过来的更现代化的编程语言，如 Scala 和 Kotlin，都允许了可变数据的存在，我们仍然可以在程序
 *  代码中拥有“状态”。此外，它们也都继承了 Java 中面向对象的特性。因此，在纯函数式语言的信徒看来，Scala、Kotlin
 *  这些语言并不能称为真正意义上的函数式语言。
 *
 * 同时，也有很多人对此并不赞同。在他们看来，所谓函数式编程语言，不应该只是严格的刻板标准，它应该根据需求的变化而发展。
 * Scala 的作者马丁就针对“函数式语言之争”的话题，发表过一篇文章来阐明类似的观点。在他看来，Scala 这种拥有更多语言特性选
 * 择的编程语言，是一种“后函数式”的编程语言，即它在几乎拥有所有函数式编程语言特性的同时，又符合了编程语言发展的趋势。
 * 从广义上看，任何“以函数为中心进行编程”的语言都可称为函数式编程。在这些编程语言中，我们可以在任何位置定义函数，同时也可
 * 以将函数作为值进行传递。
 *
 * 因此，广义的函数式编程语言并不需要强调函数是否都是“纯”的，下面来列举一些最常见的函数式语言特性：
 *
 * - 函数是头等公民；
 * - 方便的闭包语法；
 * - 递归式构造列表（list comprehension）；
 * - 柯里化的函数；
 * - 惰性求值；
 * - 模式匹配；
 * - 尾递归优化。
 *
 * 如果是支持静态类型的函数式语言，那么它们还可能支持：
 *
 * - 强大的泛型能力，包括高阶类型；
 * - Typeclass；
 * - 类型推导。
 *
 * Kotlin 支持以上具有代表性的函数式语言特性列表中的绝大多数，因此它可以被称为广义上的函数式语言。在用 Kotlin 编程时，
 * 我们经常可以利用函数式的特性来设计程序。
 *
 * TODO：函数式的概念相对复杂，具体可以参考《Kotlin 核心编程》第十章
 */
fun main(args: Array<String>) {
    //统计一个文件中所有字符串的个数
    File("build.gradle")
        .readText()
        .toCharArray()
        .filterNot(Char::isWhitespace)
        .groupBy { it }
        .map {
            it.key to it.value.size
        }
        .forEach(::println)
}