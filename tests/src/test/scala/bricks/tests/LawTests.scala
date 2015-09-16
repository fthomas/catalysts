package bricks
package tests

import org.typelevel.discipline.{Laws, Predicate}
import bricks.macros._
import bricks.testkit.{StdTest, TestModifier, TestNotifications, TestSettings, WellTested}
import org.scalacheck.Gen.Parameters
import org.scalacheck.{Arbitrary, Prop}
import bricks.scalatest.{TestSuite => StTestSuite}

class LawTests extends StTestSuite {
  implicit def groupLaws[A: Arbitrary] = GroupLaws[A]

  laws[GroupLaws, Int].check(_.group)

  laws[GroupLaws, List[Int]].check(_.additiveGroup)
}
