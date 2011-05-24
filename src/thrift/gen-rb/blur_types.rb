#
# Autogenerated by Thrift
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#


module Blur
    module ScoreType
      SUPER = 0
      AGGREGATE = 1
      BEST = 2
      CONSTANT = 3
      VALUE_MAP = {0 => "SUPER", 1 => "AGGREGATE", 2 => "BEST", 3 => "CONSTANT"}
      VALID_VALUES = Set.new([SUPER, AGGREGATE, BEST, CONSTANT]).freeze
    end

    module RecordMutationType
      DELETE_ENTIRE_RECORD = 0
      REPLACE_ENTIRE_RECORD = 1
      REPLACE_COLUMNS = 2
      APPEND_COLUMN_VALUES = 3
      VALUE_MAP = {0 => "DELETE_ENTIRE_RECORD", 1 => "REPLACE_ENTIRE_RECORD", 2 => "REPLACE_COLUMNS", 3 => "APPEND_COLUMN_VALUES"}
      VALID_VALUES = Set.new([DELETE_ENTIRE_RECORD, REPLACE_ENTIRE_RECORD, REPLACE_COLUMNS, APPEND_COLUMN_VALUES]).freeze
    end

    module RowMutationType
      DELETE_ROW = 0
      REPLACE_ROW = 1
      UPDATE_ROW = 2
      VALUE_MAP = {0 => "DELETE_ROW", 1 => "REPLACE_ROW", 2 => "UPDATE_ROW"}
      VALID_VALUES = Set.new([DELETE_ROW, REPLACE_ROW, UPDATE_ROW]).freeze
    end

    class BlurException < ::Thrift::Exception
      include ::Thrift::Struct, ::Thrift::Struct_Union
      MESSAGE = 1
      STACKTRACESTR = 2

      FIELDS = {
        MESSAGE => {:type => ::Thrift::Types::STRING, :name => 'message'},
        STACKTRACESTR => {:type => ::Thrift::Types::STRING, :name => 'stackTraceStr'}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class Selector
      include ::Thrift::Struct, ::Thrift::Struct_Union
      RECORDONLY = 1
      LOCATIONID = 2
      ROWID = 3
      RECORDID = 4
      COLUMNFAMILIESTOFETCH = 5
      COLUMNSTOFETCH = 6

      FIELDS = {
        RECORDONLY => {:type => ::Thrift::Types::BOOL, :name => 'recordOnly'},
        LOCATIONID => {:type => ::Thrift::Types::STRING, :name => 'locationId'},
        ROWID => {:type => ::Thrift::Types::STRING, :name => 'rowId'},
        RECORDID => {:type => ::Thrift::Types::STRING, :name => 'recordId'},
        COLUMNFAMILIESTOFETCH => {:type => ::Thrift::Types::SET, :name => 'columnFamiliesToFetch', :element => {:type => ::Thrift::Types::STRING}},
        COLUMNSTOFETCH => {:type => ::Thrift::Types::MAP, :name => 'columnsToFetch', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::SET, :element => {:type => ::Thrift::Types::STRING}}}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class Facet
      include ::Thrift::Struct, ::Thrift::Struct_Union
      QUERYSTR = 1
      MINIMUMNUMBEROFBLURRESULTS = 2

      FIELDS = {
        QUERYSTR => {:type => ::Thrift::Types::STRING, :name => 'queryStr'},
        MINIMUMNUMBEROFBLURRESULTS => {:type => ::Thrift::Types::I64, :name => 'minimumNumberOfBlurResults'}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class Column
      include ::Thrift::Struct, ::Thrift::Struct_Union
      NAME = 1
      VALUES = 2

      FIELDS = {
        NAME => {:type => ::Thrift::Types::STRING, :name => 'name'},
        VALUES => {:type => ::Thrift::Types::LIST, :name => 'values', :element => {:type => ::Thrift::Types::STRING}}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class ColumnFamily
      include ::Thrift::Struct, ::Thrift::Struct_Union
      FAMILY = 1
      RECORDS = 2

      FIELDS = {
        FAMILY => {:type => ::Thrift::Types::STRING, :name => 'family'},
        RECORDS => {:type => ::Thrift::Types::MAP, :name => 'records', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::SET, :element => {:type => ::Thrift::Types::STRUCT, :class => Blur::Column}}}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class Row
      include ::Thrift::Struct, ::Thrift::Struct_Union
      ID = 1
      COLUMNFAMILIES = 2

      FIELDS = {
        ID => {:type => ::Thrift::Types::STRING, :name => 'id'},
        COLUMNFAMILIES => {:type => ::Thrift::Types::SET, :name => 'columnFamilies', :element => {:type => ::Thrift::Types::STRUCT, :class => Blur::ColumnFamily}}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class FetchRowResult
      include ::Thrift::Struct, ::Thrift::Struct_Union
      ROW = 1

      FIELDS = {
        ROW => {:type => ::Thrift::Types::STRUCT, :name => 'row', :class => Blur::Row}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class FetchRecordResult
      include ::Thrift::Struct, ::Thrift::Struct_Union
      ROWID = 1
      RECORDID = 2
      COLUMNFAMILY = 3
      RECORD = 4

      FIELDS = {
        ROWID => {:type => ::Thrift::Types::STRING, :name => 'rowid'},
        RECORDID => {:type => ::Thrift::Types::STRING, :name => 'recordid'},
        COLUMNFAMILY => {:type => ::Thrift::Types::STRING, :name => 'columnFamily'},
        RECORD => {:type => ::Thrift::Types::SET, :name => 'record', :element => {:type => ::Thrift::Types::STRUCT, :class => Blur::Column}}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class FetchResult
      include ::Thrift::Struct, ::Thrift::Struct_Union
      EXISTS = 1
      DELETED = 2
      TABLE = 3
      ROWRESULT = 4
      RECORDRESULT = 5

      FIELDS = {
        EXISTS => {:type => ::Thrift::Types::BOOL, :name => 'exists'},
        DELETED => {:type => ::Thrift::Types::BOOL, :name => 'deleted'},
        TABLE => {:type => ::Thrift::Types::STRING, :name => 'table'},
        ROWRESULT => {:type => ::Thrift::Types::STRUCT, :name => 'rowResult', :class => Blur::FetchRowResult},
        RECORDRESULT => {:type => ::Thrift::Types::STRUCT, :name => 'recordResult', :class => Blur::FetchRecordResult}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class BlurQuery
      include ::Thrift::Struct, ::Thrift::Struct_Union
      QUERYSTR = 1
      SUPERQUERYON = 2
      TYPE = 3
      POSTSUPERFILTER = 4
      PRESUPERFILTER = 5
      START = 6
      FETCH = 7
      MINIMUMNUMBEROFRESULTS = 8
      MAXQUERYTIME = 9
      UUID = 10
      USERID = 11
      RESOLVEIDS = 12
      FACETS = 13
      SELECTOR = 14

      FIELDS = {
        QUERYSTR => {:type => ::Thrift::Types::STRING, :name => 'queryStr'},
        SUPERQUERYON => {:type => ::Thrift::Types::BOOL, :name => 'superQueryOn', :default => true},
        TYPE => {:type => ::Thrift::Types::I32, :name => 'type', :default =>         0, :enum_class => Blur::ScoreType},
        POSTSUPERFILTER => {:type => ::Thrift::Types::STRING, :name => 'postSuperFilter'},
        PRESUPERFILTER => {:type => ::Thrift::Types::STRING, :name => 'preSuperFilter'},
        START => {:type => ::Thrift::Types::I64, :name => 'start', :default => 0},
        FETCH => {:type => ::Thrift::Types::I32, :name => 'fetch', :default => 10},
        MINIMUMNUMBEROFRESULTS => {:type => ::Thrift::Types::I64, :name => 'minimumNumberOfResults', :default => 9223372036854775807},
        MAXQUERYTIME => {:type => ::Thrift::Types::I64, :name => 'maxQueryTime', :default => 9223372036854775807},
        UUID => {:type => ::Thrift::Types::I64, :name => 'uuid'},
        USERID => {:type => ::Thrift::Types::STRING, :name => 'userId'},
        RESOLVEIDS => {:type => ::Thrift::Types::BOOL, :name => 'resolveIds'},
        FACETS => {:type => ::Thrift::Types::LIST, :name => 'facets', :element => {:type => ::Thrift::Types::STRUCT, :class => Blur::Facet}},
        SELECTOR => {:type => ::Thrift::Types::STRUCT, :name => 'selector', :class => Blur::Selector}
      }

      def struct_fields; FIELDS; end

      def validate
        unless @type.nil? || Blur::ScoreType::VALID_VALUES.include?(@type)
          raise ::Thrift::ProtocolException.new(::Thrift::ProtocolException::UNKNOWN, 'Invalid value of field type!')
        end
      end

      ::Thrift::Struct.generate_accessors self
    end

    class BlurQuerySuggestion
      include ::Thrift::Struct, ::Thrift::Struct_Union
      QUERYSTR = 1
      TOTALRESULTS = 2
      SHARDINFO = 3
      EXCEPTIONS = 4
      QUERY = 5
      REALTIME = 6
      CPUTIME = 7

      FIELDS = {
        QUERYSTR => {:type => ::Thrift::Types::STRING, :name => 'queryStr'},
        TOTALRESULTS => {:type => ::Thrift::Types::I64, :name => 'totalResults', :default => 0},
        SHARDINFO => {:type => ::Thrift::Types::MAP, :name => 'shardInfo', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::I64}},
        EXCEPTIONS => {:type => ::Thrift::Types::LIST, :name => 'exceptions', :element => {:type => ::Thrift::Types::STRUCT, :class => Blur::BlurException}},
        QUERY => {:type => ::Thrift::Types::STRUCT, :name => 'query', :class => Blur::BlurQuery},
        REALTIME => {:type => ::Thrift::Types::I64, :name => 'realTime'},
        CPUTIME => {:type => ::Thrift::Types::I64, :name => 'cpuTime'}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class BlurQuerySuggestions
      include ::Thrift::Struct, ::Thrift::Struct_Union
      QUERYSUGGESTIONS = 1

      FIELDS = {
        QUERYSUGGESTIONS => {:type => ::Thrift::Types::LIST, :name => 'querySuggestions', :element => {:type => ::Thrift::Types::STRUCT, :class => Blur::BlurQuerySuggestion}}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class BlurResult
      include ::Thrift::Struct, ::Thrift::Struct_Union
      LOCATIONID = 1
      SCORE = 2
      REASON = 3
      FETCHRESULT = 4

      FIELDS = {
        LOCATIONID => {:type => ::Thrift::Types::STRING, :name => 'locationId'},
        SCORE => {:type => ::Thrift::Types::DOUBLE, :name => 'score'},
        REASON => {:type => ::Thrift::Types::STRING, :name => 'reason', :default => %q"UNKNOWN"},
        FETCHRESULT => {:type => ::Thrift::Types::STRUCT, :name => 'fetchResult', :class => Blur::FetchResult}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class BlurResults
      include ::Thrift::Struct, ::Thrift::Struct_Union
      TOTALRESULTS = 1
      SHARDINFO = 2
      RESULTS = 3
      EXCEPTIONS = 4
      QUERY = 5
      REALTIME = 6
      CPUTIME = 7
      FACETCOUNTS = 8

      FIELDS = {
        TOTALRESULTS => {:type => ::Thrift::Types::I64, :name => 'totalResults', :default => 0},
        SHARDINFO => {:type => ::Thrift::Types::MAP, :name => 'shardInfo', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::I64}},
        RESULTS => {:type => ::Thrift::Types::LIST, :name => 'results', :element => {:type => ::Thrift::Types::STRUCT, :class => Blur::BlurResult}},
        EXCEPTIONS => {:type => ::Thrift::Types::LIST, :name => 'exceptions', :element => {:type => ::Thrift::Types::STRUCT, :class => Blur::BlurException}},
        QUERY => {:type => ::Thrift::Types::STRUCT, :name => 'query', :class => Blur::BlurQuery},
        REALTIME => {:type => ::Thrift::Types::I64, :name => 'realTime'},
        CPUTIME => {:type => ::Thrift::Types::I64, :name => 'cpuTime'},
        FACETCOUNTS => {:type => ::Thrift::Types::LIST, :name => 'facetCounts', :element => {:type => ::Thrift::Types::I64}}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class TableDescriptor
      include ::Thrift::Struct, ::Thrift::Struct_Union
      ISENABLED = 1
      ANALYZERDEF = 2
      SHARDCOUNT = 3
      TABLEURI = 4

      FIELDS = {
        ISENABLED => {:type => ::Thrift::Types::BOOL, :name => 'isEnabled'},
        ANALYZERDEF => {:type => ::Thrift::Types::STRING, :name => 'analyzerDef'},
        SHARDCOUNT => {:type => ::Thrift::Types::I32, :name => 'shardCount'},
        TABLEURI => {:type => ::Thrift::Types::STRING, :name => 'tableUri'}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class BlurQueryStatus
      include ::Thrift::Struct, ::Thrift::Struct_Union
      QUERY = 1
      REALTIME = 2
      CPUTIME = 3
      COMPLETE = 4
      RUNNING = 5
      INTERRUPTED = 6
      UUID = 7

      FIELDS = {
        QUERY => {:type => ::Thrift::Types::STRUCT, :name => 'query', :class => Blur::BlurQuery},
        REALTIME => {:type => ::Thrift::Types::I64, :name => 'realTime'},
        CPUTIME => {:type => ::Thrift::Types::I64, :name => 'cpuTime'},
        COMPLETE => {:type => ::Thrift::Types::DOUBLE, :name => 'complete'},
        RUNNING => {:type => ::Thrift::Types::BOOL, :name => 'running'},
        INTERRUPTED => {:type => ::Thrift::Types::BOOL, :name => 'interrupted'},
        UUID => {:type => ::Thrift::Types::I64, :name => 'uuid'}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class Schema
      include ::Thrift::Struct, ::Thrift::Struct_Union
      TABLE = 1
      COLUMNFAMILIES = 2

      FIELDS = {
        TABLE => {:type => ::Thrift::Types::STRING, :name => 'table'},
        COLUMNFAMILIES => {:type => ::Thrift::Types::MAP, :name => 'columnFamilies', :key => {:type => ::Thrift::Types::STRING}, :value => {:type => ::Thrift::Types::SET, :element => {:type => ::Thrift::Types::STRING}}}
      }

      def struct_fields; FIELDS; end

      def validate
      end

      ::Thrift::Struct.generate_accessors self
    end

    class RecordMutation
      include ::Thrift::Struct, ::Thrift::Struct_Union
      RECORDMUTATIONTYPE = 1
      FAMILY = 2
      RECORDID = 3
      RECORD = 4

      FIELDS = {
        RECORDMUTATIONTYPE => {:type => ::Thrift::Types::I32, :name => 'recordMutationType', :enum_class => Blur::RecordMutationType},
        FAMILY => {:type => ::Thrift::Types::STRING, :name => 'family'},
        RECORDID => {:type => ::Thrift::Types::STRING, :name => 'recordId'},
        RECORD => {:type => ::Thrift::Types::SET, :name => 'record', :element => {:type => ::Thrift::Types::STRUCT, :class => Blur::Column}}
      }

      def struct_fields; FIELDS; end

      def validate
        unless @recordMutationType.nil? || Blur::RecordMutationType::VALID_VALUES.include?(@recordMutationType)
          raise ::Thrift::ProtocolException.new(::Thrift::ProtocolException::UNKNOWN, 'Invalid value of field recordMutationType!')
        end
      end

      ::Thrift::Struct.generate_accessors self
    end

    class RowMutation
      include ::Thrift::Struct, ::Thrift::Struct_Union
      ROWMUTATIONTYPE = 1
      ROWID = 2
      RECORDMUTATIONS = 3

      FIELDS = {
        ROWMUTATIONTYPE => {:type => ::Thrift::Types::I32, :name => 'rowMutationType', :enum_class => Blur::RowMutationType},
        ROWID => {:type => ::Thrift::Types::STRING, :name => 'rowId'},
        RECORDMUTATIONS => {:type => ::Thrift::Types::LIST, :name => 'recordMutations', :element => {:type => ::Thrift::Types::STRUCT, :class => Blur::RecordMutation}}
      }

      def struct_fields; FIELDS; end

      def validate
        unless @rowMutationType.nil? || Blur::RowMutationType::VALID_VALUES.include?(@rowMutationType)
          raise ::Thrift::ProtocolException.new(::Thrift::ProtocolException::UNKNOWN, 'Invalid value of field rowMutationType!')
        end
      end

      ::Thrift::Struct.generate_accessors self
    end

  end
