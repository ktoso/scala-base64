package tototoshi.test.base64

import tototoshi.base64._
import org.scalatest.FunSuite

class HelloSuite extends FunSuite{
  test("toBinaryString"){
    val expected = {
      "01000001" +
      "01000010" +
      "01000011" +
      "01000100" +
      "01000101" +
      "01000110" +
      "01000111"
    }

    assert(Base64.toBinaryString("ABCDEFG".getBytes().toList) == expected)
  }

  test("EncodeTable"){
    assert(Base64.encodeChar(0) == 'A')
    assert(Base64.encodeChar(53) == '1')
  }

  test("nishin"){
    println(Base64.nishin("110101"))
    assert(Base64.nishin("110101") == 53)
  }

  test("get6BitstrList"){
    val expected = List("010000", "010100", "001001", "000011", "010001",
			"000100", "010101", "000110", "010001", "110000")
//    println(expected)
//    println(Base64.get6BitStrList("ABCDEFG".getBytes().toList))
    assert(Base64.get6BitStrList("ABCDEFG".getBytes().toList) == expected)
  }

  test("get8bitStrList"){
    val expectedList = {
      "01000001" ::
      "01000010" ::
      "01000011" ::
      "01000100" ::
      "01000101" ::
      "01000110" ::
      "01000111" ::
      Nil
    }
    assert(Base64.get8bitStrList("ABCDEFG".getBytes().toList) == expectedList)
  }


  test("Encode"){
//    println(Base64.encode("ABCDEFG".getBytes.toList))
//    println(Base64.encode("hogepiyofoobar".getBytes.toList))
    assert(Base64.encode("ABCDEFG".getBytes.toList) == "QUJDREVGRw==")
    assert(Base64.encode("hogepiyofoobar".getBytes.toList) == "aG9nZXBpeW9mb29iYXI=")
  }

}
