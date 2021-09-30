export interface SearchParam {
  key: string
  param: string[]
}

export class SearchUtils {
  /**
   * SearchServiceに渡すパラメータ生成クラス
   * @param keyword
   * @param pref
   * @param feature
   * @returns
   */
  public static createParam(keyword: string[], pref: string[], feature: string[]) {
    const res = []
    res.push({ key: 'keyword', param: keyword })
    res.push({ key: 'pref', param: pref })
    res.push({ key: 'feature', param: feature })
    return res
  }

  public static createGetUriParam(keyword: string[], pref: string[], feature: string[]) {
    return `${this.joinParam(keyword, 'keyword')}${this.joinParam(pref, 'pref')}${this.joinParam(feature, 'feature')}`
  }

  static joinParam(items: string[], label: string) {
    let result = ''
    items.forEach((item) => {
      result += `&${label}=${item}`
    })
    return result
  }
}
