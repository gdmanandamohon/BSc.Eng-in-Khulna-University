#Name:Ananda Mohon Ghosh
#ID:110201
#Variables: array_keywords, array_data_type, array_operator,array_bracket,array_logical_operator,array_delemiter,array_var_separator,array_comments,arry_floatpoint
#User Define Function: is_operator(self, temp_char),is_delimeter(self, temp_char), is_comments(self, temp_char,next_char),is_ogical_operator(self, temp_char),is_bracket(self, temp_char)
#is_var_separator(self, temp_char),is_whitespace(self, temp_char),is_data_type(self, temp_string),is_keywords(self, temp_string),is_floatingpoint(self, temp_string)



__author__ = 'LazYCodeR'
class Testing:
    array_keywords = ['case','catch','class','continue','default','do','else','final','finally','for','if','native','new','public','return', 'static','switch','this','throw','throws','try','void','while','false','true','null','printf','scanf']
    array_data_type=['boolean','byte','char','float','int','short','double','long','string']
    array_operator = ['/','+','-','*','%','<','>','<','>','=','&','|',' ','!']
    array_bracket =['(',')','{','}','[',']']
    array_logical_operator = ["++","--","<=",">=","==","&&","||","*=","/=","+=","-=","!="]
    array_delemiter=[';']
    array_var_separator=[',']
    array_comments =['//','/*','*/']
    arry_floatpoint=['.','_']

    def is_operator(self, temp_char):
        if  temp_char in self.array_operator:
            return 1
        return 0
    def is_delimeter(self, temp_char):
        if(temp_char   in self.array_delemiter):
            return 1
        return 0
    def is_comments(self, temp_char,next_char):
        temp_char = temp_char+next_char
        if (temp_char  in self.array_comments):
            return 1
        return 0
    def is_ogical_operator(self, temp_char):
        if (temp_char in self.array_logical_operator):
            return 1
        return 0
    def is_bracket(self, temp_char):
        if (temp_char in self.array_bracket):
            return 1
        return 0

    def is_var_separator(self, temp_char):
        if (temp_char  in self.array_var_separator):
            return 1
        return 0
    def is_whitespace(self, temp_char):
        if (temp_char in self.array_whitespace):
            return 1
        return 0
    def is_data_type(self, temp_string):
        if (temp_string  in self.array_data_type):
            return 1
        return 0
    def is_keywords(self, temp_string):
        if (temp_string  in self.array_keywords):
            return 1
        return 0
    def is_floatingpoint(self, temp_string):
        if (temp_string  in self.arry_floatpoint):
            return 1
        return 0