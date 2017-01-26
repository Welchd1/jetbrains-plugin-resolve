// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static edu.clemson.resolve.jetbrains.ResTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ResParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ARGUMENT_LIST) {
      r = ArgumentList(b, 0);
    }
    else if (t == ASSIGN_STATEMENT) {
      r = AssignStatement(b, 0);
    }
    else if (t == CHANGING_CLAUSE) {
      r = ChangingClause(b, 0);
    }
    else if (t == CLOSE_IDENTIFIER) {
      r = CloseIdentifier(b, 0);
    }
    else if (t == CONCEPT_BLOCK) {
      r = ConceptBlock(b, 0);
    }
    else if (t == CONCEPT_EXTENSION_MODULE_DECL) {
      r = ConceptExtensionModuleDecl(b, 0);
    }
    else if (t == CONCEPT_MODULE_DECL) {
      r = ConceptModuleDecl(b, 0);
    }
    else if (t == CONSTRAINTS_CLAUSE) {
      r = ConstraintsClause(b, 0);
    }
    else if (t == CONVENTIONS_CLAUSE) {
      r = ConventionsClause(b, 0);
    }
    else if (t == CORRESPONDENCE_CLAUSE) {
      r = CorrespondenceClause(b, 0);
    }
    else if (t == DECREASING_CLAUSE) {
      r = DecreasingClause(b, 0);
    }
    else if (t == ELSE_STATEMENT) {
      r = ElseStatement(b, 0);
    }
    else if (t == ENSURES_CLAUSE) {
      r = EnsuresClause(b, 0);
    }
    else if (t == ENTAILS_CLAUSE) {
      r = EntailsClause(b, 0);
    }
    else if (t == EXEMPLAR_DECL) {
      r = ExemplarDecl(b, 0);
    }
    else if (t == EXP) {
      r = Exp(b, 0, -1);
    }
    else if (t == EXTENSION_PAIRING) {
      r = ExtensionPairing(b, 0);
    }
    else if (t == FACILITY_BLOCK) {
      r = FacilityBlock(b, 0);
    }
    else if (t == FACILITY_DECL) {
      r = FacilityDecl(b, 0);
    }
    else if (t == FACILITY_MODULE_DECL) {
      r = FacilityModuleDecl(b, 0);
    }
    else if (t == FIELD_DEF) {
      r = FieldDef(b, 0);
    }
    else if (t == FIELD_VAR_DECL_GROUP) {
      r = FieldVarDeclGroup(b, 0);
    }
    else if (t == IF_STATEMENT) {
      r = IfStatement(b, 0);
    }
    else if (t == IMPL_BLOCK) {
      r = ImplBlock(b, 0);
    }
    else if (t == IMPL_MODULE_DECL) {
      r = ImplModuleDecl(b, 0);
    }
    else if (t == IMPL_MODULE_PARAMETERS) {
      r = ImplModuleParameters(b, 0);
    }
    else if (t == INTIALIZATION_CLAUSE) {
      r = IntializationClause(b, 0);
    }
    else if (t == MAINTAINING_CLAUSE) {
      r = MaintainingClause(b, 0);
    }
    else if (t == MATH_ALTERNATIVE_ITEM_EXP) {
      r = MathAlternativeItemExp(b, 0);
    }
    else if (t == MATH_ALTERNATIVES_LIST) {
      r = MathAlternativesList(b, 0);
    }
    else if (t == MATH_ASSERTION_EXP) {
      r = MathAssertionExp(b, 0);
    }
    else if (t == MATH_CATEGORICAL_DEFN_DECL) {
      r = MathCategoricalDefnDecl(b, 0);
    }
    else if (t == MATH_CLSSFTN_COROLLARY_DECL) {
      r = MathClssftnCorollaryDecl(b, 0);
    }
    else if (t == MATH_EXP) {
      r = MathExp(b, 0, -1);
    }
    else if (t == MATH_FUNCTION_APP_LIST) {
      r = MathFunctionAppList(b, 0);
    }
    else if (t == MATH_INDUCTIVE_DEFN_DECL) {
      r = MathInductiveDefnDecl(b, 0);
    }
    else if (t == MATH_INFIX_DEFN_SIG) {
      r = MathInfixDefnSig(b, 0);
    }
    else if (t == MATH_OUTFIX_DEFN_SIG) {
      r = MathOutfixDefnSig(b, 0);
    }
    else if (t == MATH_POSTFIX_DEFN_SIG) {
      r = MathPostfixDefnSig(b, 0);
    }
    else if (t == MATH_PREFIX_DEFN_SIG) {
      r = MathPrefixDefnSig(b, 0);
    }
    else if (t == MATH_QUANTIFIED_EXP) {
      r = MathQuantifiedExp(b, 0);
    }
    else if (t == MATH_REFERENCE_EXP) {
      r = MathReferenceExp(b, 0);
    }
    else if (t == MATH_STANDARD_DEFN_DECL) {
      r = MathStandardDefnDecl(b, 0);
    }
    else if (t == MATH_SYMBOL_NAME) {
      r = MathSymbolName(b, 0);
    }
    else if (t == MATH_THEOREM_DECL) {
      r = MathTheoremDecl(b, 0);
    }
    else if (t == MATH_VAR_DECL) {
      r = MathVarDecl(b, 0);
    }
    else if (t == MATH_VAR_DECL_GROUP) {
      r = MathVarDeclGroup(b, 0);
    }
    else if (t == MATH_VAR_DEF) {
      r = MathVarDef(b, 0);
    }
    else if (t == MODULE_IDENTIFIER) {
      r = ModuleIdentifier(b, 0);
    }
    else if (t == MODULE_IDENTIFIER_SPEC) {
      r = ModuleIdentifierSpec(b, 0);
    }
    else if (t == MODULE_LIBRARY_IDENTIFIER) {
      r = ModuleLibraryIdentifier(b, 0);
    }
    else if (t == MODULE_REALIZ_ARG_LIST) {
      r = ModuleRealizArgList(b, 0);
    }
    else if (t == MODULE_SPEC_ARG_LIST) {
      r = ModuleSpecArgList(b, 0);
    }
    else if (t == NOTICE_STATEMENT) {
      r = NoticeStatement(b, 0);
    }
    else if (t == OP_BLOCK) {
      r = OpBlock(b, 0);
    }
    else if (t == OPERATION_DECL) {
      r = OperationDecl(b, 0);
    }
    else if (t == OPERATION_PROCEDURE_DECL) {
      r = OperationProcedureDecl(b, 0);
    }
    else if (t == PARAM_DECL) {
      r = ParamDecl(b, 0);
    }
    else if (t == PARAM_DEF) {
      r = ParamDef(b, 0);
    }
    else if (t == PARAMETER_MODE) {
      r = ParameterMode(b, 0);
    }
    else if (t == PRECIS_BLOCK) {
      r = PrecisBlock(b, 0);
    }
    else if (t == PRECIS_EXTENSION_MODULE_DECL) {
      r = PrecisExtensionModuleDecl(b, 0);
    }
    else if (t == PRECIS_MODULE_DECL) {
      r = PrecisModuleDecl(b, 0);
    }
    else if (t == PROCEDURE_DECL) {
      r = ProcedureDecl(b, 0);
    }
    else if (t == PROG_SYMBOL_NAME) {
      r = ProgSymbolName(b, 0);
    }
    else if (t == RECORD_TYPE) {
      r = RecordType(b, 0);
    }
    else if (t == RECORD_VAR_DECL_GROUP) {
      r = RecordVarDeclGroup(b, 0);
    }
    else if (t == REFERENCE_EXP) {
      r = ReferenceExp(b, 0);
    }
    else if (t == REQUIRES_CLAUSE) {
      r = RequiresClause(b, 0);
    }
    else if (t == SIMPLE_STATEMENT) {
      r = SimpleStatement(b, 0);
    }
    else if (t == SPEC_MODULE_PARAMETERS) {
      r = SpecModuleParameters(b, 0);
    }
    else if (t == STATEMENT) {
      r = Statement(b, 0);
    }
    else if (t == SWAP_STATEMENT) {
      r = SwapStatement(b, 0);
    }
    else if (t == TYPE) {
      r = Type(b, 0);
    }
    else if (t == TYPE_IMPL_INIT) {
      r = TypeImplInit(b, 0);
    }
    else if (t == TYPE_MODEL_DECL) {
      r = TypeModelDecl(b, 0);
    }
    else if (t == TYPE_PARAM_DECL) {
      r = TypeParamDecl(b, 0);
    }
    else if (t == TYPE_REFERENCE_EXP) {
      r = TypeReferenceExp(b, 0);
    }
    else if (t == TYPE_REPR_DECL) {
      r = TypeReprDecl(b, 0);
    }
    else if (t == USES_LIST) {
      r = UsesList(b, 0);
    }
    else if (t == VAR_DECL_GROUP) {
      r = VarDeclGroup(b, 0);
    }
    else if (t == VAR_DEF) {
      r = VarDef(b, 0);
    }
    else if (t == VAR_SPEC) {
      r = VarSpec(b, 0);
    }
    else if (t == WHILE_STATEMENT) {
      r = WhileStatement(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return ModuleDecl(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(MATH_VAR_DECL, MATH_VAR_DECL_GROUP),
    create_token_set_(EXP, INFIX_EXP, LITERAL_EXP, NESTED_EXP,
      PARAM_EXP, REFERENCE_EXP, SELECTOR_EXP),
    create_token_set_(ASSIGN_STATEMENT, ELSE_STATEMENT, IF_STATEMENT, NOTICE_STATEMENT,
      SIMPLE_STATEMENT, STATEMENT, SWAP_STATEMENT, WHILE_STATEMENT),
    create_token_set_(MATH_ALTERNATIVE_EXP, MATH_ALTERNATIVE_ITEM_EXP, MATH_ASSERTION_EXP, MATH_CART_PROD_EXP,
      MATH_CLSSFTN_ASSRT_EXP, MATH_EXP, MATH_INCOMING_EXP, MATH_INFIX_APPLY_EXP,
      MATH_LAMBDA_EXP, MATH_MIXFIX_APPLY_EXP, MATH_NESTED_EXP, MATH_OUTFIX_APPLY_EXP,
      MATH_PREFIX_APPLY_EXP, MATH_QUANTIFIED_EXP, MATH_REFERENCE_EXP, MATH_SELECTOR_EXP,
      MATH_SET_EXP, MATH_SET_RESTRICTION_EXP, RECORD_TYPE, TYPE),
  };

  /* ********************************************************** */
  // '(' ExpArgumentList? ')'
  public static boolean ArgumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, ArgumentList_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ExpArgumentList?
  private static boolean ArgumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1")) return false;
    ExpArgumentList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ':=' Exp
  public static boolean AssignStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignStatement")) return false;
    if (!nextTokenIs(b, COLON_EQUALS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _LEFT_, ASSIGN_STATEMENT, null);
    r = consumeToken(b, COLON_EQUALS);
    p = r; // pin = 1
    r = r && Exp(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // !(is)
  static boolean CategoricalSigListRec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CategoricalSigListRec")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, IS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // changing ExpArgumentList ';'
  public static boolean ChangingClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ChangingClause")) return false;
    if (!nextTokenIs(b, CHANGING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CHANGING_CLAUSE, null);
    r = consumeToken(b, CHANGING);
    p = r; // pin = 1
    r = r && report_error_(b, ExpArgumentList(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier
  public static boolean CloseIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CloseIdentifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CLOSE_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // ConceptItem*
  public static boolean ConceptBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptBlock")) return false;
    Marker m = enter_section_(b, l, _NONE_, CONCEPT_BLOCK, "<concept block>");
    int c = current_position_(b);
    while (true) {
      if (!ConceptItem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConceptBlock", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, ItemsRecover_parser_);
    return true;
  }

  /* ********************************************************** */
  // 'Enhancement' identifier SpecModuleParameters? for ReferenceExp ';'
  // UsesList?
  // RequiresClause?
  // ConceptBlock
  // end identifier ';'
  public static boolean ConceptExtensionModuleDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptExtensionModuleDecl")) return false;
    if (!nextTokenIs(b, ENHANCEMENT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONCEPT_EXTENSION_MODULE_DECL, null);
    r = consumeTokens(b, 2, ENHANCEMENT, IDENTIFIER);
    p = r; // pin = 2
    r = r && report_error_(b, ConceptExtensionModuleDecl_2(b, l + 1));
    r = p && report_error_(b, consumeToken(b, FOR)) && r;
    r = p && report_error_(b, ReferenceExp(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, SEMICOLON)) && r;
    r = p && report_error_(b, ConceptExtensionModuleDecl_6(b, l + 1)) && r;
    r = p && report_error_(b, ConceptExtensionModuleDecl_7(b, l + 1)) && r;
    r = p && report_error_(b, ConceptBlock(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, IDENTIFIER, SEMICOLON)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SpecModuleParameters?
  private static boolean ConceptExtensionModuleDecl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptExtensionModuleDecl_2")) return false;
    SpecModuleParameters(b, l + 1);
    return true;
  }

  // UsesList?
  private static boolean ConceptExtensionModuleDecl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptExtensionModuleDecl_6")) return false;
    UsesList(b, l + 1);
    return true;
  }

  // RequiresClause?
  private static boolean ConceptExtensionModuleDecl_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptExtensionModuleDecl_7")) return false;
    RequiresClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TypeModelDecl
  //     | OperationDecl
  //     | MathStandardDefnDecl
  //     | ConstraintsClause
  static boolean ConceptItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptItem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = TypeModelDecl(b, l + 1);
    if (!r) r = OperationDecl(b, l + 1);
    if (!r) r = MathStandardDefnDecl(b, l + 1);
    if (!r) r = ConstraintsClause(b, l + 1);
    exit_section_(b, l, m, r, false, ConceptItemRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // !('Type'|'Operation'|'Definition'|constraints|end)
  static boolean ConceptItemRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptItemRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !ConceptItemRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'Type'|'Operation'|'Definition'|constraints|end
  private static boolean ConceptItemRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptItemRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FAMILY_TYPE);
    if (!r) r = consumeToken(b, OPERATION);
    if (!r) r = consumeToken(b, DEFINITION);
    if (!r) r = consumeToken(b, CONSTRAINTS);
    if (!r) r = consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'Concept' identifier SpecModuleParameters? ';'
  // UsesList?
  // RequiresClause?
  // ConceptBlock
  // end identifier ';'
  public static boolean ConceptModuleDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptModuleDecl")) return false;
    if (!nextTokenIs(b, CONCEPT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONCEPT_MODULE_DECL, null);
    r = consumeTokens(b, 1, CONCEPT, IDENTIFIER);
    p = r; // pin = 1
    r = r && report_error_(b, ConceptModuleDecl_2(b, l + 1));
    r = p && report_error_(b, consumeToken(b, SEMICOLON)) && r;
    r = p && report_error_(b, ConceptModuleDecl_4(b, l + 1)) && r;
    r = p && report_error_(b, ConceptModuleDecl_5(b, l + 1)) && r;
    r = p && report_error_(b, ConceptBlock(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, IDENTIFIER, SEMICOLON)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SpecModuleParameters?
  private static boolean ConceptModuleDecl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptModuleDecl_2")) return false;
    SpecModuleParameters(b, l + 1);
    return true;
  }

  // UsesList?
  private static boolean ConceptModuleDecl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptModuleDecl_4")) return false;
    UsesList(b, l + 1);
    return true;
  }

  // RequiresClause?
  private static boolean ConceptModuleDecl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConceptModuleDecl_5")) return false;
    RequiresClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // constraints MathAssertionExp ';'
  public static boolean ConstraintsClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstraintsClause")) return false;
    if (!nextTokenIs(b, CONSTRAINTS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONSTRAINTS_CLAUSE, null);
    r = consumeToken(b, CONSTRAINTS);
    p = r; // pin = 1
    r = r && report_error_(b, MathAssertionExp(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // conventions MathAssertionExp (EntailsClause)? ';'
  public static boolean ConventionsClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConventionsClause")) return false;
    if (!nextTokenIs(b, CONVENTIONS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONVENTIONS_CLAUSE, null);
    r = consumeToken(b, CONVENTIONS);
    p = r; // pin = 1
    r = r && report_error_(b, MathAssertionExp(b, l + 1));
    r = p && report_error_(b, ConventionsClause_2(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EntailsClause)?
  private static boolean ConventionsClause_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConventionsClause_2")) return false;
    ConventionsClause_2_0(b, l + 1);
    return true;
  }

  // (EntailsClause)
  private static boolean ConventionsClause_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConventionsClause_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EntailsClause(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // correspondence MathAssertionExp ';'
  public static boolean CorrespondenceClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CorrespondenceClause")) return false;
    if (!nextTokenIs(b, CORRESPONDENCE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CORRESPONDENCE_CLAUSE, null);
    r = consumeToken(b, CORRESPONDENCE);
    p = r; // pin = 1
    r = r && report_error_(b, MathAssertionExp(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // decreasing MathAssertionExp ';'
  public static boolean DecreasingClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DecreasingClause")) return false;
    if (!nextTokenIs(b, DECREASING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECREASING_CLAUSE, null);
    r = consumeToken(b, DECREASING);
    p = r; // pin = 1
    r = r && report_error_(b, MathAssertionExp(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // else Statements
  public static boolean ElseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElseStatement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ELSE_STATEMENT, null);
    r = consumeToken(b, ELSE);
    p = r; // pin = 1
    r = r && Statements(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ensures MathAssertionExp ';'
  public static boolean EnsuresClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnsuresClause")) return false;
    if (!nextTokenIs(b, ENSURES)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENSURES_CLAUSE, null);
    r = consumeToken(b, ENSURES);
    p = r; // pin = 1
    r = r && report_error_(b, MathAssertionExp(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // which_entails MathExp
  public static boolean EntailsClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EntailsClause")) return false;
    if (!nextTokenIs(b, WHICH_ENTAILS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENTAILS_CLAUSE, null);
    r = consumeToken(b, WHICH_ENTAILS);
    p = r; // pin = 1
    r = r && MathExp(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // exemplar identifier ';'
  public static boolean ExemplarDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExemplarDecl")) return false;
    if (!nextTokenIs(b, EXEMPLAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXEMPLAR_DECL, null);
    r = consumeTokens(b, 2, EXEMPLAR, IDENTIFIER, SEMICOLON);
    p = r; // pin = 2
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Exp (',' Exp)*
  static boolean ExpArgumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpArgumentList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = Exp(b, l + 1, -1);
    p = r; // pin = 1
    r = r && ExpArgumentList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' Exp)*
  private static boolean ExpArgumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpArgumentList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ExpArgumentList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpArgumentList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' Exp
  private static boolean ExpArgumentList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpArgumentList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && Exp(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (ExtensionPairing)*
  static boolean ExtensionList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtensionList")) return false;
    Marker m = enter_section_(b, l, _NONE_);
    int c = current_position_(b);
    while (true) {
      if (!ExtensionList_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExtensionList", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, ExtensionListRec_parser_);
    return true;
  }

  // (ExtensionPairing)
  private static boolean ExtensionList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtensionList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExtensionPairing(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(';')
  static boolean ExtensionListRec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtensionListRec")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // enhanced by ModuleIdentifier ModuleSpecArgList? [FromClause] (externally)?
  // realized by ModuleIdentifier ModuleRealizArgList? [FromClause]
  public static boolean ExtensionPairing(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtensionPairing")) return false;
    if (!nextTokenIs(b, ENHANCED)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXTENSION_PAIRING, null);
    r = consumeTokens(b, 1, ENHANCED, BY);
    p = r; // pin = 1
    r = r && report_error_(b, ModuleIdentifier(b, l + 1));
    r = p && report_error_(b, ExtensionPairing_3(b, l + 1)) && r;
    r = p && report_error_(b, ExtensionPairing_4(b, l + 1)) && r;
    r = p && report_error_(b, ExtensionPairing_5(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, REALIZED, BY)) && r;
    r = p && report_error_(b, ModuleIdentifier(b, l + 1)) && r;
    r = p && report_error_(b, ExtensionPairing_9(b, l + 1)) && r;
    r = p && ExtensionPairing_10(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ModuleSpecArgList?
  private static boolean ExtensionPairing_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtensionPairing_3")) return false;
    ModuleSpecArgList(b, l + 1);
    return true;
  }

  // [FromClause]
  private static boolean ExtensionPairing_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtensionPairing_4")) return false;
    FromClause(b, l + 1);
    return true;
  }

  // (externally)?
  private static boolean ExtensionPairing_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtensionPairing_5")) return false;
    consumeToken(b, EXTERNALLY);
    return true;
  }

  // ModuleRealizArgList?
  private static boolean ExtensionPairing_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtensionPairing_9")) return false;
    ModuleRealizArgList(b, l + 1);
    return true;
  }

  // [FromClause]
  private static boolean ExtensionPairing_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExtensionPairing_10")) return false;
    FromClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FacilityItem*
  public static boolean FacilityBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityBlock")) return false;
    Marker m = enter_section_(b, l, _NONE_, FACILITY_BLOCK, "<facility block>");
    int c = current_position_(b);
    while (true) {
      if (!FacilityItem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FacilityBlock", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, ItemsRecover_parser_);
    return true;
  }

  /* ********************************************************** */
  // 'Facility' identifier is ModuleIdentifier ModuleSpecArgList? [FromClause]
  // (externally)? realized by ModuleIdentifier ModuleRealizArgList? [FromClause]
  // ExtensionList? ';'
  public static boolean FacilityDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityDecl")) return false;
    if (!nextTokenIs(b, FACILITY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FACILITY_DECL, null);
    r = consumeTokens(b, 2, FACILITY, IDENTIFIER, IS);
    p = r; // pin = 2
    r = r && report_error_(b, ModuleIdentifier(b, l + 1));
    r = p && report_error_(b, FacilityDecl_4(b, l + 1)) && r;
    r = p && report_error_(b, FacilityDecl_5(b, l + 1)) && r;
    r = p && report_error_(b, FacilityDecl_6(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, REALIZED, BY)) && r;
    r = p && report_error_(b, ModuleIdentifier(b, l + 1)) && r;
    r = p && report_error_(b, FacilityDecl_10(b, l + 1)) && r;
    r = p && report_error_(b, FacilityDecl_11(b, l + 1)) && r;
    r = p && report_error_(b, FacilityDecl_12(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ModuleSpecArgList?
  private static boolean FacilityDecl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityDecl_4")) return false;
    ModuleSpecArgList(b, l + 1);
    return true;
  }

  // [FromClause]
  private static boolean FacilityDecl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityDecl_5")) return false;
    FromClause(b, l + 1);
    return true;
  }

  // (externally)?
  private static boolean FacilityDecl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityDecl_6")) return false;
    consumeToken(b, EXTERNALLY);
    return true;
  }

  // ModuleRealizArgList?
  private static boolean FacilityDecl_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityDecl_10")) return false;
    ModuleRealizArgList(b, l + 1);
    return true;
  }

  // [FromClause]
  private static boolean FacilityDecl_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityDecl_11")) return false;
    FromClause(b, l + 1);
    return true;
  }

  // ExtensionList?
  private static boolean FacilityDecl_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityDecl_12")) return false;
    ExtensionList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FacilityDecl
  //     | OperationProcedureDecl
  //     | TypeReprDecl
  //     | MathStandardDefnDecl
  static boolean FacilityItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityItem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = FacilityDecl(b, l + 1);
    if (!r) r = OperationProcedureDecl(b, l + 1);
    if (!r) r = TypeReprDecl(b, l + 1);
    if (!r) r = MathStandardDefnDecl(b, l + 1);
    exit_section_(b, l, m, r, false, FacilityItemRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // !('Facility'|'Definition'|'Operation'|'Type'|end)
  static boolean FacilityItemRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityItemRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !FacilityItemRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'Facility'|'Definition'|'Operation'|'Type'|end
  private static boolean FacilityItemRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityItemRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FACILITY);
    if (!r) r = consumeToken(b, DEFINITION);
    if (!r) r = consumeToken(b, OPERATION);
    if (!r) r = consumeToken(b, FAMILY_TYPE);
    if (!r) r = consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'Facility' identifier ';'
  // UsesList?
  // RequiresClause?
  // FacilityBlock
  // end identifier ';'
  public static boolean FacilityModuleDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityModuleDecl")) return false;
    if (!nextTokenIs(b, FACILITY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FACILITY_MODULE_DECL, null);
    r = consumeTokens(b, 3, FACILITY, IDENTIFIER, SEMICOLON);
    p = r; // pin = 3
    r = r && report_error_(b, FacilityModuleDecl_3(b, l + 1));
    r = p && report_error_(b, FacilityModuleDecl_4(b, l + 1)) && r;
    r = p && report_error_(b, FacilityBlock(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, IDENTIFIER, SEMICOLON)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // UsesList?
  private static boolean FacilityModuleDecl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityModuleDecl_3")) return false;
    UsesList(b, l + 1);
    return true;
  }

  // RequiresClause?
  private static boolean FacilityModuleDecl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FacilityModuleDecl_4")) return false;
    RequiresClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean FieldDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDef")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FIELD_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // FieldVarDefList ':' Type
  public static boolean FieldVarDeclGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldVarDeclGroup")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIELD_VAR_DECL_GROUP, null);
    r = FieldVarDefList(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, COLON));
    r = p && Type(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // FieldDef &(!(';'))(',' FieldDef)*
  static boolean FieldVarDefList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldVarDefList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = FieldDef(b, l + 1);
    p = r; // pin = 1
    r = r && FieldVarDefList_1(b, l + 1);
    r = r && FieldVarDefList_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &(!(';'))
  private static boolean FieldVarDefList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldVarDefList_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = FieldVarDefList_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !(';')
  private static boolean FieldVarDefList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldVarDefList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' FieldDef)*
  private static boolean FieldVarDefList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldVarDefList_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!FieldVarDefList_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FieldVarDefList_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' FieldDef
  private static boolean FieldVarDefList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldVarDefList_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && FieldDef(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // from ModuleLibraryIdentifier
  static boolean FromClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FromClause")) return false;
    if (!nextTokenIs(b, FROM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, FROM);
    p = r; // pin = 1
    r = r && ModuleLibraryIdentifier(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'If' Exp then Statements (ElseStatement)? end ';'
  public static boolean IfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement")) return false;
    if (!nextTokenIs(b, PROG_IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_STATEMENT, null);
    r = consumeToken(b, PROG_IF);
    p = r; // pin = 1
    r = r && report_error_(b, Exp(b, l + 1, -1));
    r = p && report_error_(b, consumeToken(b, THEN)) && r;
    r = p && report_error_(b, Statements(b, l + 1)) && r;
    r = p && report_error_(b, IfStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, SEMICOLON)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (ElseStatement)?
  private static boolean IfStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_4")) return false;
    IfStatement_4_0(b, l + 1);
    return true;
  }

  // (ElseStatement)
  private static boolean IfStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ElseStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ImplItem*
  public static boolean ImplBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplBlock")) return false;
    Marker m = enter_section_(b, l, _NONE_, IMPL_BLOCK, "<impl block>");
    int c = current_position_(b);
    while (true) {
      if (!ImplItem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImplBlock", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, ItemsRecover_parser_);
    return true;
  }

  /* ********************************************************** */
  // TypeReprDecl
  //     | OperationProcedureDecl
  //     | FacilityDecl
  //     | ProcedureDecl
  //     | MathStandardDefnDecl
  static boolean ImplItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplItem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = TypeReprDecl(b, l + 1);
    if (!r) r = OperationProcedureDecl(b, l + 1);
    if (!r) r = FacilityDecl(b, l + 1);
    if (!r) r = ProcedureDecl(b, l + 1);
    if (!r) r = MathStandardDefnDecl(b, l + 1);
    exit_section_(b, l, m, r, false, ImplItemRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // !('Type'|'Operation'|'Facility'|'Recursive'|'Definition'|'Procedure'|end)
  static boolean ImplItemRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplItemRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !ImplItemRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'Type'|'Operation'|'Facility'|'Recursive'|'Definition'|'Procedure'|end
  private static boolean ImplItemRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplItemRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FAMILY_TYPE);
    if (!r) r = consumeToken(b, OPERATION);
    if (!r) r = consumeToken(b, FACILITY);
    if (!r) r = consumeToken(b, RECURSIVE);
    if (!r) r = consumeToken(b, DEFINITION);
    if (!r) r = consumeToken(b, PROCEDURE);
    if (!r) r = consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'Realization' identifier ImplModuleParameters? for ReferenceExp (of ReferenceExp)? ';'
  // UsesList?
  // RequiresClause?
  // ImplBlock
  // end identifier ';'
  public static boolean ImplModuleDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplModuleDecl")) return false;
    if (!nextTokenIs(b, REALIZATION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPL_MODULE_DECL, null);
    r = consumeTokens(b, 1, REALIZATION, IDENTIFIER);
    p = r; // pin = 1
    r = r && report_error_(b, ImplModuleDecl_2(b, l + 1));
    r = p && report_error_(b, consumeToken(b, FOR)) && r;
    r = p && report_error_(b, ReferenceExp(b, l + 1)) && r;
    r = p && report_error_(b, ImplModuleDecl_5(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, SEMICOLON)) && r;
    r = p && report_error_(b, ImplModuleDecl_7(b, l + 1)) && r;
    r = p && report_error_(b, ImplModuleDecl_8(b, l + 1)) && r;
    r = p && report_error_(b, ImplBlock(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, IDENTIFIER, SEMICOLON)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ImplModuleParameters?
  private static boolean ImplModuleDecl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplModuleDecl_2")) return false;
    ImplModuleParameters(b, l + 1);
    return true;
  }

  // (of ReferenceExp)?
  private static boolean ImplModuleDecl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplModuleDecl_5")) return false;
    ImplModuleDecl_5_0(b, l + 1);
    return true;
  }

  // of ReferenceExp
  private static boolean ImplModuleDecl_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplModuleDecl_5_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OF);
    p = r; // pin = 1
    r = r && ReferenceExp(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // UsesList?
  private static boolean ImplModuleDecl_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplModuleDecl_7")) return false;
    UsesList(b, l + 1);
    return true;
  }

  // RequiresClause?
  private static boolean ImplModuleDecl_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplModuleDecl_8")) return false;
    RequiresClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ImplParamDecl  (';' ImplParamDecl)*
  static boolean ImplModuleParamList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplModuleParamList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ImplParamDecl(b, l + 1);
    p = r; // pin = 1
    r = r && ImplModuleParamList_1(b, l + 1);
    exit_section_(b, l, m, r, p, ParamListRec_parser_);
    return r || p;
  }

  // (';' ImplParamDecl)*
  private static boolean ImplModuleParamList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplModuleParamList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ImplModuleParamList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImplModuleParamList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ';' ImplParamDecl
  private static boolean ImplModuleParamList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplModuleParamList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, SEMICOLON);
    p = r; // pin = 1
    r = r && ImplParamDecl(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '(' ImplModuleParamList ')'
  public static boolean ImplModuleParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplModuleParameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPL_MODULE_PARAMETERS, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, ImplModuleParamList(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ParamDecl|OperationDecl
  static boolean ImplParamDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImplParamDecl")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParamDecl(b, l + 1);
    if (!r) r = OperationDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // initialization (EnsuresClause)
  public static boolean IntializationClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IntializationClause")) return false;
    if (!nextTokenIs(b, INITIALIZATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INITIALIZATION);
    r = r && IntializationClause_1(b, l + 1);
    exit_section_(b, m, INTIALIZATION_CLAUSE, r);
    return r;
  }

  // (EnsuresClause)
  private static boolean IntializationClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IntializationClause_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EnsuresClause(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !('end')
  static boolean ItemsRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ItemsRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !ItemsRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('end')
  private static boolean ItemsRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ItemsRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "end");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // maintaining MathAssertionExp ';'
  public static boolean MaintainingClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MaintainingClause")) return false;
    if (!nextTokenIs(b, MAINTAINING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAINTAINING_CLAUSE, null);
    r = consumeToken(b, MAINTAINING);
    p = r; // pin = 1
    r = r && report_error_(b, MathAssertionExp(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MathExp (if MathExp ';' | otherwise ';')
  public static boolean MathAlternativeItemExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathAlternativeItemExp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_ALTERNATIVE_ITEM_EXP, "<math alternative item exp>");
    r = MathExp(b, l + 1, -1);
    r = r && MathAlternativeItemExp_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // if MathExp ';' | otherwise ';'
  private static boolean MathAlternativeItemExp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathAlternativeItemExp_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MathAlternativeItemExp_1_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, OTHERWISE, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // if MathExp ';'
  private static boolean MathAlternativeItemExp_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathAlternativeItemExp_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && MathExp(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MathAlternativeItemExp+
  public static boolean MathAlternativesList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathAlternativesList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_ALTERNATIVES_LIST, "<math alternatives list>");
    r = MathAlternativeItemExp(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!MathAlternativeItemExp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MathAlternativesList", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MathExp (',' MathExp)*
  static boolean MathArgList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathArgList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = MathExp(b, l + 1, -1);
    p = r; // pin = 1
    r = r && MathArgList_1(b, l + 1);
    exit_section_(b, l, m, r, p, ParamListRec_parser_);
    return r || p;
  }

  // (',' MathExp)*
  private static boolean MathArgList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathArgList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!MathArgList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MathArgList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' MathExp
  private static boolean MathArgList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathArgList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && MathExp(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MathQuantifiedExp|MathExp
  public static boolean MathAssertionExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathAssertionExp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, MATH_ASSERTION_EXP, "<math assertion exp>");
    r = MathQuantifiedExp(b, l + 1);
    if (!r) r = MathExp(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '⟨'|'⟩'|'⌈'|'⌉'|'⎝'|'⎠'|'∥'|'['|']'|'|'
  public static boolean MathBracketName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathBracketName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_SYMBOL_NAME, "<math bracket name>");
    r = consumeToken(b, LANGLE);
    if (!r) r = consumeToken(b, RANGLE);
    if (!r) r = consumeToken(b, LCEIL);
    if (!r) r = consumeToken(b, RCEIL);
    if (!r) r = consumeToken(b, LCUP);
    if (!r) r = consumeToken(b, RCUP);
    if (!r) r = consumeToken(b, DBL_BAR);
    if (!r) r = consumeToken(b, LBRACK);
    if (!r) r = consumeToken(b, RBRACK);
    if (!r) r = consumeToken(b, BAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'Categorical' 'Definition' for
  // MathPrefixDefnSigs is MathExp ';'
  public static boolean MathCategoricalDefnDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathCategoricalDefnDecl")) return false;
    if (!nextTokenIs(b, CATEGORICAL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_CATEGORICAL_DEFN_DECL, null);
    r = consumeTokens(b, 2, CATEGORICAL, DEFINITION, FOR);
    p = r; // pin = 2
    r = r && report_error_(b, MathPrefixDefnSigs(b, l + 1));
    r = p && report_error_(b, consumeToken(b, IS)) && r;
    r = p && report_error_(b, MathExp(b, l + 1, -1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'Classification' 'Corollary' ':' MathAssertionExp ';'
  public static boolean MathClssftnCorollaryDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathClssftnCorollaryDecl")) return false;
    if (!nextTokenIs(b, CLASSIFICATION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_CLSSFTN_COROLLARY_DECL, null);
    r = consumeTokens(b, 1, CLASSIFICATION, COROLLARY, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, MathAssertionExp(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '(' MathDefnParamList ')'
  static boolean MathDefinitionParams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathDefinitionParams")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, MathDefnParamList(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MathVarDeclGroup (',' MathVarDeclGroup)*
  static boolean MathDefnParamList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathDefnParamList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = MathVarDeclGroup(b, l + 1);
    p = r; // pin = 1
    r = r && MathDefnParamList_1(b, l + 1);
    exit_section_(b, l, m, r, p, ParamListRec_parser_);
    return r || p;
  }

  // (',' MathVarDeclGroup)*
  private static boolean MathDefnParamList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathDefnParamList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!MathDefnParamList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MathDefnParamList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' MathVarDeclGroup
  private static boolean MathDefnParamList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathDefnParamList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && MathVarDeclGroup(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MathPrefixDefnSig | MathPostfixDefnSig | MathOutfixDefnSig | MathInfixDefnSig
  static boolean MathDefnSig(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathDefnSig")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MathPrefixDefnSig(b, l + 1);
    if (!r) r = MathPostfixDefnSig(b, l + 1);
    if (!r) r = MathOutfixDefnSig(b, l + 1);
    if (!r) r = MathInfixDefnSig(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' MathArgList ')'
  public static boolean MathFunctionAppList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathFunctionAppList")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_FUNCTION_APP_LIST, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, MathArgList(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'Inductive' 'Definition' MathDefnSig is
  // '(i.)' MathAssertionExp ';'
  // '(ii.)' MathAssertionExp ';'
  public static boolean MathInductiveDefnDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathInductiveDefnDecl")) return false;
    if (!nextTokenIs(b, INDUCTIVE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_INDUCTIVE_DEFN_DECL, null);
    r = consumeTokens(b, 2, INDUCTIVE, DEFINITION);
    p = r; // pin = 2
    r = r && report_error_(b, MathDefnSig(b, l + 1));
    r = p && report_error_(b, consumeTokens(b, -1, IS, IND_BASE)) && r;
    r = p && report_error_(b, MathAssertionExp(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, SEMICOLON, IND_HYPO)) && r;
    r = p && report_error_(b, MathAssertionExp(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '(' MathVarDecl ')' MathSymbolName '(' MathVarDecl ')' ':' MathExp
  public static boolean MathInfixDefnSig(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathInfixDefnSig")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_INFIX_DEFN_SIG, null);
    r = consumeToken(b, LPAREN);
    r = r && MathVarDecl(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && MathSymbolName(b, l + 1);
    p = r; // pin = 4
    r = r && report_error_(b, consumeToken(b, LPAREN));
    r = p && report_error_(b, MathVarDecl(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, RPAREN, COLON)) && r;
    r = p && MathExp(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MathExp (',' MathExp)*
  static boolean MathNonStdAppList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathNonStdAppList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = MathExp(b, l + 1, -1);
    p = r; // pin = 1
    r = r && MathNonStdAppList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' MathExp)*
  private static boolean MathNonStdAppList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathNonStdAppList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!MathNonStdAppList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MathNonStdAppList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' MathExp
  private static boolean MathNonStdAppList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathNonStdAppList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && MathExp(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MathSymbolExp
  static boolean MathOpSymbolName(PsiBuilder b, int l) {
    return MathSymbolExp(b, l + 1);
  }

  /* ********************************************************** */
  // MathBracketName '(' MathVarDecl ')' MathBracketName ':' MathExp
  public static boolean MathOutfixDefnSig(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathOutfixDefnSig")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_OUTFIX_DEFN_SIG, "<math outfix defn sig>");
    r = MathBracketName(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LPAREN));
    r = p && report_error_(b, MathVarDecl(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RPAREN)) && r;
    r = p && report_error_(b, MathBracketName(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && MathExp(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '(' MathVarDecl ')' MathBracketName '(' MathVarDecl ')' MathBracketName ':' MathExp
  public static boolean MathPostfixDefnSig(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPostfixDefnSig")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && MathVarDecl(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && MathBracketName(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && MathVarDecl(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && MathBracketName(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && MathExp(b, l + 1, -1);
    exit_section_(b, m, MATH_POSTFIX_DEFN_SIG, r);
    return r;
  }

  /* ********************************************************** */
  // MathPrefixNameList MathDefinitionParams? ':' MathExp
  public static boolean MathPrefixDefnSig(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPrefixDefnSig")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_PREFIX_DEFN_SIG, "<math prefix defn sig>");
    r = MathPrefixNameList(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, MathPrefixDefnSig_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && MathExp(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // MathDefinitionParams?
  private static boolean MathPrefixDefnSig_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPrefixDefnSig_1")) return false;
    MathDefinitionParams(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MathPrefixDefnSig (',' MathPrefixDefnSig)*
  static boolean MathPrefixDefnSigs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPrefixDefnSigs")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = MathPrefixDefnSig(b, l + 1);
    r = r && MathPrefixDefnSigs_1(b, l + 1);
    exit_section_(b, l, m, r, false, CategoricalSigListRec_parser_);
    return r;
  }

  // (',' MathPrefixDefnSig)*
  private static boolean MathPrefixDefnSigs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPrefixDefnSigs_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!MathPrefixDefnSigs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MathPrefixDefnSigs_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' MathPrefixDefnSig
  private static boolean MathPrefixDefnSigs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPrefixDefnSigs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && MathPrefixDefnSig(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(':'|';'|'(')
  static boolean MathPrefixListRec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPrefixListRec")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !MathPrefixListRec_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ':'|';'|'('
  private static boolean MathPrefixListRec_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPrefixListRec_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, LPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MathSymbolName (',' MathSymbolName)*
  static boolean MathPrefixNameList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPrefixNameList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = MathSymbolName(b, l + 1);
    p = r; // pin = 1
    r = r && MathPrefixNameList_1(b, l + 1);
    exit_section_(b, l, m, r, p, MathPrefixListRec_parser_);
    return r || p;
  }

  // (',' MathSymbolName)*
  private static boolean MathPrefixNameList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPrefixNameList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!MathPrefixNameList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MathPrefixNameList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' MathSymbolName
  private static boolean MathPrefixNameList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathPrefixNameList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && MathSymbolName(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '::' MathSymbolName
  public static boolean MathQualifiedReferenceExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathQualifiedReferenceExp")) return false;
    if (!nextTokenIs(b, COLON_COLON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, MATH_REFERENCE_EXP, null);
    r = consumeToken(b, COLON_COLON);
    r = r && MathSymbolName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('∃'|'∀') MathVarDeclGroup ',' MathAssertionExp
  public static boolean MathQuantifiedExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathQuantifiedExp")) return false;
    if (!nextTokenIs(b, "<math quantified exp>", FORALL, EXISTS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _COLLAPSE_, MATH_QUANTIFIED_EXP, "<math quantified exp>");
    r = MathQuantifiedExp_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, MathVarDeclGroup(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COMMA)) && r;
    r = p && MathAssertionExp(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '∃'|'∀'
  private static boolean MathQuantifiedExp_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathQuantifiedExp_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXISTS);
    if (!r) r = consumeToken(b, FORALL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MathSymbolName
  public static boolean MathReferenceExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathReferenceExp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_REFERENCE_EXP, "<math reference exp>");
    r = MathSymbolName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('Chainable')? ('Implicit'?) 'Definition'  MathDefnSig (is MathAssertionExp)? ';'
  public static boolean MathStandardDefnDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathStandardDefnDecl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_STANDARD_DEFN_DECL, "<math standard defn decl>");
    r = MathStandardDefnDecl_0(b, l + 1);
    r = r && MathStandardDefnDecl_1(b, l + 1);
    r = r && consumeToken(b, DEFINITION);
    p = r; // pin = 3
    r = r && report_error_(b, MathDefnSig(b, l + 1));
    r = p && report_error_(b, MathStandardDefnDecl_4(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('Chainable')?
  private static boolean MathStandardDefnDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathStandardDefnDecl_0")) return false;
    consumeToken(b, CHAINABLE);
    return true;
  }

  // 'Implicit'?
  private static boolean MathStandardDefnDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathStandardDefnDecl_1")) return false;
    consumeToken(b, IMPLICIT);
    return true;
  }

  // (is MathAssertionExp)?
  private static boolean MathStandardDefnDecl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathStandardDefnDecl_4")) return false;
    MathStandardDefnDecl_4_0(b, l + 1);
    return true;
  }

  // is MathAssertionExp
  private static boolean MathStandardDefnDecl_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathStandardDefnDecl_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IS);
    r = r && MathAssertionExp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier|int|symbol|mathsymbol|true|false
  public static boolean MathSymbolName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathSymbolName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_SYMBOL_NAME, "<math symbol name>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, MATHSYMBOL);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('Corollary'|'Theorem') identifier ':' MathAssertionExp ';'
  public static boolean MathTheoremDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathTheoremDecl")) return false;
    if (!nextTokenIs(b, "<math theorem decl>", COROLLARY, THEOREM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_THEOREM_DECL, "<math theorem decl>");
    r = MathTheoremDecl_0(b, l + 1);
    r = r && consumeTokens(b, 1, IDENTIFIER, COLON);
    p = r; // pin = 2
    r = r && report_error_(b, MathAssertionExp(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'Corollary'|'Theorem'
  private static boolean MathTheoremDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathTheoremDecl_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COROLLARY);
    if (!r) r = consumeToken(b, THEOREM);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MathVarDef ':' MathExp
  public static boolean MathVarDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathVarDecl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_VAR_DECL, "<math var decl>");
    r = MathVarDef(b, l + 1);
    r = r && consumeToken(b, COLON);
    p = r; // pin = 2
    r = r && MathExp(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MathVarDeclList ':' MathExp
  public static boolean MathVarDeclGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathVarDeclGroup")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_VAR_DECL_GROUP, "<math var decl group>");
    r = MathVarDeclList(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, COLON));
    r = p && MathExp(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MathVarDef &(!(')')) (',' MathVarDef)*
  static boolean MathVarDeclList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathVarDeclList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = MathVarDef(b, l + 1);
    p = r; // pin = 1
    r = r && MathVarDeclList_1(b, l + 1);
    r = r && MathVarDeclList_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &(!(')'))
  private static boolean MathVarDeclList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathVarDeclList_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = MathVarDeclList_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !(')')
  private static boolean MathVarDeclList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathVarDeclList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' MathVarDef)*
  private static boolean MathVarDeclList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathVarDeclList_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!MathVarDeclList_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MathVarDeclList_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' MathVarDef
  private static boolean MathVarDeclList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathVarDeclList_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && MathVarDef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MathSymbolName
  public static boolean MathVarDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathVarDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_VAR_DEF, "<math var def>");
    r = MathSymbolName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PrecisModuleDecl
  //     | PrecisExtensionModuleDecl
  //     | ConceptExtensionModuleDecl
  //     | ConceptModuleDecl
  //     | ImplModuleDecl
  //     | FacilityModuleDecl
  static boolean ModuleDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleDecl")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PrecisModuleDecl(b, l + 1);
    if (!r) r = PrecisExtensionModuleDecl(b, l + 1);
    if (!r) r = ConceptExtensionModuleDecl(b, l + 1);
    if (!r) r = ConceptModuleDecl(b, l + 1);
    if (!r) r = ImplModuleDecl(b, l + 1);
    if (!r) r = FacilityModuleDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean ModuleIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleIdentifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, MODULE_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // ModuleIdentifier [FromClause]
  public static boolean ModuleIdentifierSpec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleIdentifierSpec")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODULE_IDENTIFIER_SPEC, null);
    r = ModuleIdentifier(b, l + 1);
    p = r; // pin = 1
    r = r && ModuleIdentifierSpec_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [FromClause]
  private static boolean ModuleIdentifierSpec_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleIdentifierSpec_1")) return false;
    FromClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier ('.' identifier)*
  public static boolean ModuleLibraryIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleLibraryIdentifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODULE_LIBRARY_IDENTIFIER, null);
    r = consumeToken(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && ModuleLibraryIdentifier_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('.' identifier)*
  private static boolean ModuleLibraryIdentifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleLibraryIdentifier_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ModuleLibraryIdentifier_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ModuleLibraryIdentifier_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '.' identifier
  private static boolean ModuleLibraryIdentifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleLibraryIdentifier_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, DOT, IDENTIFIER);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '(' ExpArgumentList ')'
  public static boolean ModuleRealizArgList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleRealizArgList")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODULE_REALIZ_ARG_LIST, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, ExpArgumentList(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '(' SpecArgumentList ')'
  public static boolean ModuleSpecArgList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleSpecArgList")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODULE_SPEC_ARG_LIST, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, SpecArgumentList(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TypeReferenceExp QualifiedTypeReferenceExp?
  static boolean NamedType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedType")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeReferenceExp(b, l + 1);
    r = r && NamedType_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QualifiedTypeReferenceExp?
  private static boolean NamedType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedType_1")) return false;
    QualifiedTypeReferenceExp(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'Notice' MathExp ';'
  public static boolean NoticeStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NoticeStatement")) return false;
    if (!nextTokenIs(b, NOTICE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NOTICE_STATEMENT, null);
    r = consumeToken(b, NOTICE);
    p = r; // pin = 1
    r = r && report_error_(b, MathExp(b, l + 1, -1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // VarDeclGroup* Statements?
  public static boolean OpBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OpBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OP_BLOCK, "<op block>");
    r = OpBlock_0(b, l + 1);
    r = r && OpBlock_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VarDeclGroup*
  private static boolean OpBlock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OpBlock_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!VarDeclGroup(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "OpBlock_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // Statements?
  private static boolean OpBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OpBlock_1")) return false;
    Statements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ParamDecl (';' ParamDecl)*
  static boolean OpParamList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OpParamList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ParamDecl(b, l + 1);
    p = r; // pin = 1
    r = r && OpParamList_1(b, l + 1);
    exit_section_(b, l, m, r, p, ParamListRec_parser_);
    return r || p;
  }

  // (';' ParamDecl)*
  private static boolean OpParamList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OpParamList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!OpParamList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "OpParamList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ';' ParamDecl
  private static boolean OpParamList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OpParamList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    r = r && ParamDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('Recursive')? 'Procedure' OpBlock
  static boolean OpProcBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OpProcBody")) return false;
    if (!nextTokenIs(b, "", PROCEDURE, RECURSIVE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = OpProcBody_0(b, l + 1);
    r = r && consumeToken(b, PROCEDURE);
    p = r; // pin = 2
    r = r && OpBlock(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('Recursive')?
  private static boolean OpProcBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OpProcBody_0")) return false;
    consumeToken(b, RECURSIVE);
    return true;
  }

  /* ********************************************************** */
  // 'Operation' identifier OperationLikeParameters (':' Type)? ';'
  // RequiresClause? EnsuresClause?
  public static boolean OperationDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationDecl")) return false;
    if (!nextTokenIs(b, OPERATION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OPERATION_DECL, null);
    r = consumeTokens(b, 2, OPERATION, IDENTIFIER);
    p = r; // pin = 2
    r = r && report_error_(b, OperationLikeParameters(b, l + 1));
    r = p && report_error_(b, OperationDecl_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, SEMICOLON)) && r;
    r = p && report_error_(b, OperationDecl_5(b, l + 1)) && r;
    r = p && OperationDecl_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (':' Type)?
  private static boolean OperationDecl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationDecl_3")) return false;
    OperationDecl_3_0(b, l + 1);
    return true;
  }

  // ':' Type
  private static boolean OperationDecl_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationDecl_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RequiresClause?
  private static boolean OperationDecl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationDecl_5")) return false;
    RequiresClause(b, l + 1);
    return true;
  }

  // EnsuresClause?
  private static boolean OperationDecl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationDecl_6")) return false;
    EnsuresClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '(' OpParamList? ')'
  static boolean OperationLikeParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationLikeParameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, OperationLikeParameters_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // OpParamList?
  private static boolean OperationLikeParameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationLikeParameters_1")) return false;
    OpParamList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'Operation' identifier OperationLikeParameters (':' Type)? ';'
  // RequiresClause? EnsuresClause?
  // OpProcBody
  // end CloseIdentifier ';'
  public static boolean OperationProcedureDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationProcedureDecl")) return false;
    if (!nextTokenIs(b, OPERATION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OPERATION_PROCEDURE_DECL, null);
    r = consumeTokens(b, 2, OPERATION, IDENTIFIER);
    p = r; // pin = 2
    r = r && report_error_(b, OperationLikeParameters(b, l + 1));
    r = p && report_error_(b, OperationProcedureDecl_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, SEMICOLON)) && r;
    r = p && report_error_(b, OperationProcedureDecl_5(b, l + 1)) && r;
    r = p && report_error_(b, OperationProcedureDecl_6(b, l + 1)) && r;
    r = p && report_error_(b, OpProcBody(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && report_error_(b, CloseIdentifier(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (':' Type)?
  private static boolean OperationProcedureDecl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationProcedureDecl_3")) return false;
    OperationProcedureDecl_3_0(b, l + 1);
    return true;
  }

  // ':' Type
  private static boolean OperationProcedureDecl_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationProcedureDecl_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RequiresClause?
  private static boolean OperationProcedureDecl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationProcedureDecl_5")) return false;
    RequiresClause(b, l + 1);
    return true;
  }

  // EnsuresClause?
  private static boolean OperationProcedureDecl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OperationProcedureDecl_6")) return false;
    EnsuresClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ParameterMode ParamDefinitionListNoPin ':' Type
  public static boolean ParamDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDecl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAM_DECL, "<param decl>");
    r = ParameterMode(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, ParamDefinitionListNoPin(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && Type(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier
  public static boolean ParamDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDef")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PARAM_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // ParamDef &(!(';'|')')) (',' ParamDef)*
  static boolean ParamDefinitionListNoPin(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ParamDef(b, l + 1);
    p = r; // pin = 1
    r = r && ParamDefinitionListNoPin_1(b, l + 1);
    r = r && ParamDefinitionListNoPin_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &(!(';'|')'))
  private static boolean ParamDefinitionListNoPin_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = ParamDefinitionListNoPin_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !(';'|')')
  private static boolean ParamDefinitionListNoPin_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !ParamDefinitionListNoPin_1_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ';'|')'
  private static boolean ParamDefinitionListNoPin_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ParamDef)*
  private static boolean ParamDefinitionListNoPin_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ParamDefinitionListNoPin_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParamDefinitionListNoPin_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' ParamDef
  private static boolean ParamDefinitionListNoPin_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ParamDef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(')'|';')
  static boolean ParamListRec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamListRec")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !ParamListRec_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ')'|';'
  private static boolean ParamListRec_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamListRec_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // alters|updates|clears|restores|preserves|replaces|evaluates|identifier
  public static boolean ParameterMode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterMode")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_MODE, "<parameter mode>");
    r = consumeToken(b, ALTERS);
    if (!r) r = consumeToken(b, UPDATES);
    if (!r) r = consumeToken(b, CLEARS);
    if (!r) r = consumeToken(b, RESTORES);
    if (!r) r = consumeToken(b, PRESERVES);
    if (!r) r = consumeToken(b, REPLACES);
    if (!r) r = consumeToken(b, EVALUATES);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PrecisItem*
  public static boolean PrecisBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrecisBlock")) return false;
    Marker m = enter_section_(b, l, _NONE_, PRECIS_BLOCK, "<precis block>");
    int c = current_position_(b);
    while (true) {
      if (!PrecisItem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PrecisBlock", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, ItemsRecover_parser_);
    return true;
  }

  /* ********************************************************** */
  // 'Extension' identifier for
  // ReferenceExp ';'
  // UsesList?
  // PrecisBlock
  // end identifier ';'
  public static boolean PrecisExtensionModuleDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrecisExtensionModuleDecl")) return false;
    if (!nextTokenIs(b, EXTENSION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PRECIS_EXTENSION_MODULE_DECL, null);
    r = consumeTokens(b, 2, EXTENSION, IDENTIFIER, FOR);
    p = r; // pin = 2
    r = r && report_error_(b, ReferenceExp(b, l + 1));
    r = p && report_error_(b, consumeToken(b, SEMICOLON)) && r;
    r = p && report_error_(b, PrecisExtensionModuleDecl_5(b, l + 1)) && r;
    r = p && report_error_(b, PrecisBlock(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, IDENTIFIER, SEMICOLON)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // UsesList?
  private static boolean PrecisExtensionModuleDecl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrecisExtensionModuleDecl_5")) return false;
    UsesList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MathTheoremDecl
  //         | MathStandardDefnDecl
  //         | MathCategoricalDefnDecl
  //         | MathClssftnCorollaryDecl
  //         | MathInductiveDefnDecl
  static boolean PrecisItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrecisItem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = MathTheoremDecl(b, l + 1);
    if (!r) r = MathStandardDefnDecl(b, l + 1);
    if (!r) r = MathCategoricalDefnDecl(b, l + 1);
    if (!r) r = MathClssftnCorollaryDecl(b, l + 1);
    if (!r) r = MathInductiveDefnDecl(b, l + 1);
    exit_section_(b, l, m, r, false, PrecisItemRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // !('Definition'|'Implicit'|'Theorem'|'Corollary'|'Categorical'|'Inductive'|'Classification'|'Chainable'|end)
  static boolean PrecisItemRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrecisItemRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !PrecisItemRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'Definition'|'Implicit'|'Theorem'|'Corollary'|'Categorical'|'Inductive'|'Classification'|'Chainable'|end
  private static boolean PrecisItemRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrecisItemRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFINITION);
    if (!r) r = consumeToken(b, IMPLICIT);
    if (!r) r = consumeToken(b, THEOREM);
    if (!r) r = consumeToken(b, COROLLARY);
    if (!r) r = consumeToken(b, CATEGORICAL);
    if (!r) r = consumeToken(b, INDUCTIVE);
    if (!r) r = consumeToken(b, CLASSIFICATION);
    if (!r) r = consumeToken(b, CHAINABLE);
    if (!r) r = consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'Precis' identifier ';'
  // UsesList?
  // PrecisBlock
  // end identifier ';'
  public static boolean PrecisModuleDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrecisModuleDecl")) return false;
    if (!nextTokenIs(b, PRECIS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PRECIS_MODULE_DECL, null);
    r = consumeTokens(b, 2, PRECIS, IDENTIFIER, SEMICOLON);
    p = r; // pin = 2
    r = r && report_error_(b, PrecisModuleDecl_3(b, l + 1));
    r = p && report_error_(b, PrecisBlock(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, IDENTIFIER, SEMICOLON)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // UsesList?
  private static boolean PrecisModuleDecl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrecisModuleDecl_3")) return false;
    UsesList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ('Recursive')? 'Procedure' identifier OperationLikeParameters (':' Type)? ';'
  // OpBlock
  // end CloseIdentifier ';'
  public static boolean ProcedureDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ProcedureDecl")) return false;
    if (!nextTokenIs(b, "<procedure decl>", PROCEDURE, RECURSIVE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PROCEDURE_DECL, "<procedure decl>");
    r = ProcedureDecl_0(b, l + 1);
    r = r && consumeTokens(b, 2, PROCEDURE, IDENTIFIER);
    p = r; // pin = 3
    r = r && report_error_(b, OperationLikeParameters(b, l + 1));
    r = p && report_error_(b, ProcedureDecl_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, SEMICOLON)) && r;
    r = p && report_error_(b, OpBlock(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && report_error_(b, CloseIdentifier(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('Recursive')?
  private static boolean ProcedureDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ProcedureDecl_0")) return false;
    consumeToken(b, RECURSIVE);
    return true;
  }

  // (':' Type)?
  private static boolean ProcedureDecl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ProcedureDecl_4")) return false;
    ProcedureDecl_4_0(b, l + 1);
    return true;
  }

  // ':' Type
  private static boolean ProcedureDecl_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ProcedureDecl_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier|symbol
  public static boolean ProgSymbolName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ProgSymbolName")) return false;
    if (!nextTokenIs(b, "<prog symbol name>", IDENTIFIER, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROG_SYMBOL_NAME, "<prog symbol name>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, SYMBOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '::' identifier
  public static boolean QualifiedReferenceExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QualifiedReferenceExp")) return false;
    if (!nextTokenIs(b, COLON_COLON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, REFERENCE_EXP, null);
    r = consumeTokens(b, 0, COLON_COLON, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '::' identifier
  public static boolean QualifiedTypeReferenceExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QualifiedTypeReferenceExp")) return false;
    if (!nextTokenIs(b, COLON_COLON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, TYPE_REFERENCE_EXP, null);
    r = consumeTokens(b, 0, COLON_COLON, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'Record' RecordVarDeclGroup* end
  public static boolean RecordType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RecordType")) return false;
    if (!nextTokenIs(b, RECORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RECORD_TYPE, null);
    r = consumeToken(b, RECORD);
    p = r; // pin = 1
    r = r && report_error_(b, RecordType_1(b, l + 1));
    r = p && consumeToken(b, END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // RecordVarDeclGroup*
  private static boolean RecordType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RecordType_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!RecordVarDeclGroup(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "RecordType_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // FieldVarDeclGroup ';'
  public static boolean RecordVarDeclGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RecordVarDeclGroup")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RECORD_VAR_DECL_GROUP, null);
    r = FieldVarDeclGroup(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier
  public static boolean ReferenceExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceExp")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, REFERENCE_EXP, r);
    return r;
  }

  /* ********************************************************** */
  // requires MathAssertionExp (EntailsClause)? ';'
  public static boolean RequiresClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RequiresClause")) return false;
    if (!nextTokenIs(b, REQUIRES)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REQUIRES_CLAUSE, null);
    r = consumeToken(b, REQUIRES);
    p = r; // pin = 1
    r = r && report_error_(b, MathAssertionExp(b, l + 1));
    r = p && report_error_(b, RequiresClause_2(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EntailsClause)?
  private static boolean RequiresClause_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RequiresClause_2")) return false;
    RequiresClause_2_0(b, l + 1);
    return true;
  }

  // (EntailsClause)
  private static boolean RequiresClause_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RequiresClause_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EntailsClause(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MathVarDeclGroup ';'
  static boolean ResMathCartVarGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResMathCartVarGroup")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = MathVarDeclGroup(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Exp (AssignStatement|SwapStatement)? ';'
  public static boolean SimpleStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleStatement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _COLLAPSE_, SIMPLE_STATEMENT, "<simple statement>");
    r = Exp(b, l + 1, -1);
    p = r; // pin = 1
    r = r && report_error_(b, SimpleStatement_1(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (AssignStatement|SwapStatement)?
  private static boolean SimpleStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleStatement_1")) return false;
    SimpleStatement_1_0(b, l + 1);
    return true;
  }

  // AssignStatement|SwapStatement
  private static boolean SimpleStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignStatement(b, l + 1);
    if (!r) r = SwapStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Exp|MathExp
  static boolean SpecArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SpecArg")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Exp(b, l + 1, -1);
    if (!r) r = MathExp(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SpecArg (',' SpecArg)*
  static boolean SpecArgumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SpecArgumentList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = SpecArg(b, l + 1);
    p = r; // pin = 1
    r = r && SpecArgumentList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' SpecArg)*
  private static boolean SpecArgumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SpecArgumentList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!SpecArgumentList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SpecArgumentList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' SpecArg
  private static boolean SpecArgumentList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SpecArgumentList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && SpecArg(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // SpecParamDecl  (';' SpecParamDecl)*
  static boolean SpecModuleParamList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SpecModuleParamList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = SpecParamDecl(b, l + 1);
    p = r; // pin = 1
    r = r && SpecModuleParamList_1(b, l + 1);
    exit_section_(b, l, m, r, p, ParamListRec_parser_);
    return r || p;
  }

  // (';' SpecParamDecl)*
  private static boolean SpecModuleParamList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SpecModuleParamList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!SpecModuleParamList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SpecModuleParamList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ';' SpecParamDecl
  private static boolean SpecModuleParamList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SpecModuleParamList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, SEMICOLON);
    p = r; // pin = 1
    r = r && SpecParamDecl(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '(' SpecModuleParamList ')'
  public static boolean SpecModuleParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SpecModuleParameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SPEC_MODULE_PARAMETERS, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, SpecModuleParamList(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TypeParamDecl | ParamDecl | MathStandardDefnDecl
  static boolean SpecParamDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SpecParamDecl")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeParamDecl(b, l + 1);
    if (!r) r = ParamDecl(b, l + 1);
    if (!r) r = MathStandardDefnDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SimpleStatement | WhileStatement | IfStatement | NoticeStatement
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, STATEMENT, "<statement>");
    r = SimpleStatement(b, l + 1);
    if (!r) r = WhileStatement(b, l + 1);
    if (!r) r = IfStatement(b, l + 1);
    if (!r) r = NoticeStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(end|':='|':=:'|'If'|'While'|else|'Notice'|identifier)
  static boolean StatementRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !StatementRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // end|':='|':=:'|'If'|'While'|else|'Notice'|identifier
  private static boolean StatementRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, END);
    if (!r) r = consumeToken(b, COLON_EQUALS);
    if (!r) r = consumeToken(b, COLON_EQUALS_COLON);
    if (!r) r = consumeToken(b, PROG_IF);
    if (!r) r = consumeToken(b, WHILE);
    if (!r) r = consumeToken(b, ELSE);
    if (!r) r = consumeToken(b, NOTICE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Statement*
  static boolean Statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements")) return false;
    Marker m = enter_section_(b, l, _NONE_);
    int c = current_position_(b);
    while (true) {
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Statements", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, StatementRecover_parser_);
    return true;
  }

  /* ********************************************************** */
  // ':=:' Exp
  public static boolean SwapStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwapStatement")) return false;
    if (!nextTokenIs(b, COLON_EQUALS_COLON)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _LEFT_, SWAP_STATEMENT, null);
    r = consumeToken(b, COLON_EQUALS_COLON);
    p = r; // pin = 1
    r = r && Exp(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // RecordType | NamedType
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    if (!nextTokenIs(b, "<type>", RECORD, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, TYPE, "<type>");
    r = RecordType(b, l + 1);
    if (!r) r = NamedType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // initialization (RequiresClause)? (EnsuresClause)?
  // OpBlock end ';'
  public static boolean TypeImplInit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeImplInit")) return false;
    if (!nextTokenIs(b, INITIALIZATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INITIALIZATION);
    r = r && TypeImplInit_1(b, l + 1);
    r = r && TypeImplInit_2(b, l + 1);
    r = r && OpBlock(b, l + 1);
    r = r && consumeTokens(b, 0, END, SEMICOLON);
    exit_section_(b, m, TYPE_IMPL_INIT, r);
    return r;
  }

  // (RequiresClause)?
  private static boolean TypeImplInit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeImplInit_1")) return false;
    TypeImplInit_1_0(b, l + 1);
    return true;
  }

  // (RequiresClause)
  private static boolean TypeImplInit_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeImplInit_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RequiresClause(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EnsuresClause)?
  private static boolean TypeImplInit_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeImplInit_2")) return false;
    TypeImplInit_2_0(b, l + 1);
    return true;
  }

  // (EnsuresClause)
  private static boolean TypeImplInit_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeImplInit_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EnsuresClause(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'Type' family identifier TypeModelPortion ';'
  //     ExemplarDecl ConstraintsClause? IntializationClause?
  public static boolean TypeModelDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeModelDecl")) return false;
    if (!nextTokenIs(b, FAMILY_TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_MODEL_DECL, null);
    r = consumeTokens(b, 3, FAMILY_TYPE, FAMILY, IDENTIFIER);
    p = r; // pin = 3
    r = r && report_error_(b, TypeModelPortion(b, l + 1));
    r = p && report_error_(b, consumeToken(b, SEMICOLON)) && r;
    r = p && report_error_(b, ExemplarDecl(b, l + 1)) && r;
    r = p && report_error_(b, TypeModelDecl_6(b, l + 1)) && r;
    r = p && TypeModelDecl_7(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ConstraintsClause?
  private static boolean TypeModelDecl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeModelDecl_6")) return false;
    ConstraintsClause(b, l + 1);
    return true;
  }

  // IntializationClause?
  private static boolean TypeModelDecl_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeModelDecl_7")) return false;
    IntializationClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // is modeled by MathExp
  static boolean TypeModelPortion(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeModelPortion")) return false;
    if (!nextTokenIs(b, IS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IS, MODELED, BY);
    r = r && MathExp(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'type' identifier
  public static boolean TypeParamDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParamDecl")) return false;
    if (!nextTokenIs(b, PARAM_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 2, PARAM_TYPE, IDENTIFIER);
    exit_section_(b, m, TYPE_PARAM_DECL, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean TypeReferenceExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeReferenceExp")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_REFERENCE_EXP, r);
    return r;
  }

  /* ********************************************************** */
  // 'Type' identifier is (RecordType|Type) ';'
  // ExemplarDecl
  // ConventionsClause?
  // CorrespondenceClause?
  // TypeImplInit?
  public static boolean TypeReprDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeReprDecl")) return false;
    if (!nextTokenIs(b, FAMILY_TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_REPR_DECL, null);
    r = consumeTokens(b, 2, FAMILY_TYPE, IDENTIFIER, IS);
    p = r; // pin = 2
    r = r && report_error_(b, TypeReprDecl_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, SEMICOLON)) && r;
    r = p && report_error_(b, ExemplarDecl(b, l + 1)) && r;
    r = p && report_error_(b, TypeReprDecl_6(b, l + 1)) && r;
    r = p && report_error_(b, TypeReprDecl_7(b, l + 1)) && r;
    r = p && TypeReprDecl_8(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // RecordType|Type
  private static boolean TypeReprDecl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeReprDecl_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RecordType(b, l + 1);
    if (!r) r = Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ConventionsClause?
  private static boolean TypeReprDecl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeReprDecl_6")) return false;
    ConventionsClause(b, l + 1);
    return true;
  }

  // CorrespondenceClause?
  private static boolean TypeReprDecl_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeReprDecl_7")) return false;
    CorrespondenceClause(b, l + 1);
    return true;
  }

  // TypeImplInit?
  private static boolean TypeReprDecl_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeReprDecl_8")) return false;
    TypeImplInit(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // uses UsesSpecs ';'
  public static boolean UsesList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsesList")) return false;
    if (!nextTokenIs(b, USES)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, USES_LIST, null);
    r = consumeToken(b, USES);
    p = r; // pin = 1
    r = r && report_error_(b, UsesSpecs(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ModuleIdentifierSpec (',' ModuleIdentifierSpec)*
  static boolean UsesSpecs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsesSpecs")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ModuleIdentifierSpec(b, l + 1);
    p = r; // pin = 1
    r = r && UsesSpecs_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' ModuleIdentifierSpec)*
  private static boolean UsesSpecs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsesSpecs_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!UsesSpecs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "UsesSpecs_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' ModuleIdentifierSpec
  private static boolean UsesSpecs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsesSpecs_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && ModuleIdentifierSpec(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'Var' VarSpec ';'
  public static boolean VarDeclGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDeclGroup")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECL_GROUP, null);
    r = consumeToken(b, VAR);
    p = r; // pin = 1
    r = r && report_error_(b, VarSpec(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier
  public static boolean VarDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDef")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VAR_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // VarDef &(!(';'))(',' VarDef)*
  static boolean VarDefList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDefList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = VarDef(b, l + 1);
    p = r; // pin = 1
    r = r && VarDefList_1(b, l + 1);
    r = r && VarDefList_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &(!(';'))
  private static boolean VarDefList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDefList_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = VarDefList_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !(';')
  private static boolean VarDefList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDefList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' VarDef)*
  private static boolean VarDefList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDefList_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!VarDefList_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VarDefList_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' VarDef
  private static boolean VarDefList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDefList_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && VarDef(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // VarDefList ':' Type
  public static boolean VarSpec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarSpec")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VAR_SPEC, null);
    r = VarDefList(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, COLON));
    r = p && Type(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'While' Exp ChangingClause? MaintainingClause? DecreasingClause?
  // do Statements end ';'
  public static boolean WhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, WHILE_STATEMENT, null);
    r = consumeToken(b, WHILE);
    p = r; // pin = 1
    r = r && report_error_(b, Exp(b, l + 1, -1));
    r = p && report_error_(b, WhileStatement_2(b, l + 1)) && r;
    r = p && report_error_(b, WhileStatement_3(b, l + 1)) && r;
    r = p && report_error_(b, WhileStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, DO)) && r;
    r = p && report_error_(b, Statements(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, SEMICOLON)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ChangingClause?
  private static boolean WhileStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_2")) return false;
    ChangingClause(b, l + 1);
    return true;
  }

  // MaintainingClause?
  private static boolean WhileStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_3")) return false;
    MaintainingClause(b, l + 1);
    return true;
  }

  // DecreasingClause?
  private static boolean WhileStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_4")) return false;
    DecreasingClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expression root: Exp
  // Operator priority table:
  // 0: BINARY(InfixExp)
  // 1: POSTFIX(ParamExp)
  // 2: ATOM(NestedExp)
  // 3: ATOM(LiteralExp) BINARY(SelectorExp) ATOM(NameExp)
  public static boolean Exp(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Exp")) return false;
    addVariant(b, "<exp>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<exp>");
    r = NestedExp(b, l + 1);
    if (!r) r = LiteralExp(b, l + 1);
    if (!r) r = NameExp(b, l + 1);
    p = r;
    r = r && Exp_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean Exp_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Exp_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && ProgSymbolName(b, l + 1)) {
        r = Exp(b, l, 0);
        exit_section_(b, l, m, INFIX_EXP, r, true, null);
      }
      else if (g < 1 && leftMarkerIs(b, REFERENCE_EXP) && ArgumentList(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, PARAM_EXP, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, DOT)) {
        r = Exp(b, l, 3);
        exit_section_(b, l, m, SELECTOR_EXP, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // '(' Exp ')'
  public static boolean NestedExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NestedExp")) return false;
    if (!nextTokenIsSmart(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NESTED_EXP, null);
    r = consumeTokenSmart(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, Exp(b, l + 1, -1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // int|string|true|false
  public static boolean LiteralExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralExp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXP, "<literal exp>");
    r = consumeTokenSmart(b, INT);
    if (!r) r = consumeTokenSmart(b, STRING);
    if (!r) r = consumeTokenSmart(b, TRUE);
    if (!r) r = consumeTokenSmart(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ReferenceExp QualifiedReferenceExp?
  public static boolean NameExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameExp")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, REFERENCE_EXP, null);
    r = ReferenceExp(b, l + 1);
    r = r && NameExp_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // QualifiedReferenceExp?
  private static boolean NameExp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameExp_1")) return false;
    QualifiedReferenceExp(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expression root: MathExp
  // Operator priority table:
  // 0: BINARY(MathInfixApplyExp)
  // 1: POSTFIX(MathPrefixApplyExp)
  // 2: POSTFIX(MathMixfixApplyExp)
  // 3: ATOM(MathNestedExp)
  // 4: ATOM(MathIncomingExp) ATOM(MathSymbolExp) BINARY(MathSelectorExp) ATOM(MathLambdaExp)
  //    ATOM(MathAlternativeExp) BINARY(MathClssftnAssrtExp) PREFIX(MathOutfixApplyExp) ATOM(MathCartProdExp)
  //    ATOM(MathSetExp) ATOM(MathSetRestrictionExp)
  public static boolean MathExp(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "MathExp")) return false;
    addVariant(b, "<math exp>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<math exp>");
    r = MathNestedExp(b, l + 1);
    if (!r) r = MathIncomingExp(b, l + 1);
    if (!r) r = MathSymbolExp(b, l + 1);
    if (!r) r = MathLambdaExp(b, l + 1);
    if (!r) r = MathAlternativeExp(b, l + 1);
    if (!r) r = MathOutfixApplyExp(b, l + 1);
    if (!r) r = MathCartProdExp(b, l + 1);
    if (!r) r = MathSetExp(b, l + 1);
    if (!r) r = MathSetRestrictionExp(b, l + 1);
    p = r;
    r = r && MathExp_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean MathExp_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "MathExp_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && MathOpSymbolName(b, l + 1)) {
        r = MathExp(b, l, 0);
        exit_section_(b, l, m, MATH_INFIX_APPLY_EXP, r, true, null);
      }
      else if (g < 1 && MathFunctionAppList(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, MATH_PREFIX_APPLY_EXP, r, true, null);
      }
      else if (g < 2 && MathMixfixApplyExp_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, MATH_MIXFIX_APPLY_EXP, r, true, null);
      }
      else if (g < 4 && consumeTokenSmart(b, DOT)) {
        r = MathExp(b, l, 4);
        exit_section_(b, l, m, MATH_SELECTOR_EXP, r, true, null);
      }
      else if (g < 4 && consumeTokenSmart(b, COLON)) {
        r = MathExp(b, l, 4);
        exit_section_(b, l, m, MATH_CLSSFTN_ASSRT_EXP, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // MathBracketName MathNonStdAppList MathBracketName
  private static boolean MathMixfixApplyExp_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathMixfixApplyExp_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MathBracketName(b, l + 1);
    r = r && MathNonStdAppList(b, l + 1);
    r = r && MathBracketName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' MathAssertionExp ')'
  public static boolean MathNestedExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathNestedExp")) return false;
    if (!nextTokenIsSmart(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_NESTED_EXP, null);
    r = consumeTokenSmart(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, MathAssertionExp(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '#' MathSymbolExp
  public static boolean MathIncomingExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathIncomingExp")) return false;
    if (!nextTokenIsSmart(b, POUND)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_INCOMING_EXP, null);
    r = consumeTokenSmart(b, POUND);
    p = r; // pin = 1
    r = r && MathSymbolExp(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // MathReferenceExp MathQualifiedReferenceExp?
  public static boolean MathSymbolExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathSymbolExp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, MATH_REFERENCE_EXP, "<math symbol exp>");
    r = MathReferenceExp(b, l + 1);
    r = r && MathSymbolExp_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // MathQualifiedReferenceExp?
  private static boolean MathSymbolExp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathSymbolExp_1")) return false;
    MathQualifiedReferenceExp(b, l + 1);
    return true;
  }

  // 'λ' MathVarDecl ','  MathExp
  public static boolean MathLambdaExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathLambdaExp")) return false;
    if (!nextTokenIsSmart(b, LAMBDA)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_LAMBDA_EXP, null);
    r = consumeTokenSmart(b, LAMBDA);
    p = r; // pin = 1
    r = r && report_error_(b, MathVarDecl(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COMMA)) && r;
    r = p && MathExp(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '{{' MathAlternativesList '}}'
  public static boolean MathAlternativeExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathAlternativeExp")) return false;
    if (!nextTokenIsSmart(b, DBL_LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_ALTERNATIVE_EXP, null);
    r = consumeTokenSmart(b, DBL_LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, MathAlternativesList(b, l + 1));
    r = p && consumeToken(b, DBL_RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  public static boolean MathOutfixApplyExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathOutfixApplyExp")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = MathBracketName(b, l + 1);
    p = r;
    r = p && MathExp(b, l, -1);
    r = p && report_error_(b, MathBracketName(b, l + 1)) && r;
    exit_section_(b, l, m, MATH_OUTFIX_APPLY_EXP, r, p, null);
    return r || p;
  }

  // 'Cart_Prod' ResMathCartVarGroup+  end
  public static boolean MathCartProdExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathCartProdExp")) return false;
    if (!nextTokenIsSmart(b, CART_PROD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_CART_PROD_EXP, null);
    r = consumeTokenSmart(b, CART_PROD);
    p = r; // pin = 1
    r = r && report_error_(b, MathCartProdExp_1(b, l + 1));
    r = p && consumeToken(b, END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ResMathCartVarGroup+
  private static boolean MathCartProdExp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathCartProdExp_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ResMathCartVarGroup(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!ResMathCartVarGroup(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MathCartProdExp_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' MathExp? '}'
  public static boolean MathSetExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathSetExp")) return false;
    if (!nextTokenIsSmart(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACE);
    r = r && MathSetExp_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, MATH_SET_EXP, r);
    return r;
  }

  // MathExp?
  private static boolean MathSetExp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathSetExp_1")) return false;
    MathExp(b, l + 1, -1);
    return true;
  }

  // '{' MathVarDecl '|' MathExp '}'
  public static boolean MathSetRestrictionExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathSetRestrictionExp")) return false;
    if (!nextTokenIsSmart(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATH_SET_RESTRICTION_EXP, null);
    r = consumeTokenSmart(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, MathVarDecl(b, l + 1));
    r = p && report_error_(b, consumeToken(b, BAR)) && r;
    r = p && report_error_(b, MathExp(b, l + 1, -1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  final static Parser CategoricalSigListRec_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return CategoricalSigListRec(b, l + 1);
    }
  };
  final static Parser ConceptItemRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return ConceptItemRecover(b, l + 1);
    }
  };
  final static Parser ExtensionListRec_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return ExtensionListRec(b, l + 1);
    }
  };
  final static Parser FacilityItemRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return FacilityItemRecover(b, l + 1);
    }
  };
  final static Parser ImplItemRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return ImplItemRecover(b, l + 1);
    }
  };
  final static Parser ItemsRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return ItemsRecover(b, l + 1);
    }
  };
  final static Parser MathPrefixListRec_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return MathPrefixListRec(b, l + 1);
    }
  };
  final static Parser ParamListRec_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return ParamListRec(b, l + 1);
    }
  };
  final static Parser PrecisItemRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return PrecisItemRecover(b, l + 1);
    }
  };
  final static Parser StatementRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return StatementRecover(b, l + 1);
    }
  };
}
